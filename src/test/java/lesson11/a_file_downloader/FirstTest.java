package lesson11.a_file_downloader;

import de.redsix.pdfcompare.PdfComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

    private static final Logger LOG = LogManager.getLogger(FirstTest.class);

    LoginPage loginPage = new LoginPage(driver);
    @Test
    public void test_download() throws Exception {
        loginPage.visit();
        assertThat(titleContains("Login"));
        loginPage.login();
        assertThat(titleContains("My account"));

        $(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]")).click();
        assertThat(titleContains("Order history"));

        FileDownloader fileDownloader = new FileDownloader(driver);
        fileDownloader.setURI($(By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[6]/a")).getAttribute("href"));
        File actualFile = fileDownloader.downloadFile();
        int httpStatusCode = fileDownloader.getLastDownloadHTTPStatus();

        Assert.assertThat("Check status.", httpStatusCode, is(200));
        Assert.assertThat(new PdfComparator(new File("IN035042.pdf"), actualFile)
                .compare().writeTo("diffOutputPass"), is(true));
    }
}