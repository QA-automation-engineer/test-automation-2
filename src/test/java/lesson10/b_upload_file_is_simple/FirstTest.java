package lesson10.b_upload_file_is_simple;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

    private static final Logger LOG = LogManager.getLogger(FirstTest.class);

    LoginPage loginPage = new LoginPage(driver);
    @Test
    public void loginTest(){
        open("https://www.google.com.ua/search?q=1&source=lnms&tbm=isch&sa=X&ved=0ahUKEwi1qOPv1cHaAhVEGCwKHTQXAYoQ_AUICigB&biw=1536&bih=636");
        assertThat(titleContains("Google"));
        $(By.id("qbi")).click();
        $(By.linkText("Завантажте зображення")).click();
        $(By.id("qbfile")).sendKeys("C:\\Users\\vmuser\\IdeaProjects\\test-automation-2\\reports\\IDE-test-build-2018-04-17_18-47-34\\screenshots\\screenshot.png");
        assertThat(textToBePresentInElementLocated(By.xpath("//*[@id=\"topstuff\"]/div/div[2]/a"), "live edit prestashop 1.6"));
    }
}