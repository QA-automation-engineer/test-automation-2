package lesson06.e_explicit_wait_helps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

@RunWith(JUnit4.class)
public class FirstTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
//        driver.manage().timeouts().setScriptTimeout(10, SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void firstResultShouldContainExpectedText() throws InterruptedException {
        String query1 = "Dress";
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys(query1);
        (new WebDriverWait(driver, 10))
                .until(textToBePresentInElementLocated(By.xpath("//*[@id='index']/div[2]/ul/li[1]"), query1));

        driver.findElement(By.id("search_query_top")).clear();
        String query2 = "T-shirt";
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys(query2);

        (new WebDriverWait(driver, 10))
                .until(textToBePresentInElementLocated(By.xpath("//*[@id='index']/div[2]/ul/li[1]"), query2));
    }
}