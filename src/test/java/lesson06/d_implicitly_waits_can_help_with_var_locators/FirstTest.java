package lesson06.d_implicitly_waits_can_help_with_var_locators;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class FirstTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, SECONDS);

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

        assertThat(getElement(query1).getText(),
                containsString(query1));

        driver.findElement(By.id("search_query_top")).clear();
        String query2 = "T-shirt";
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys(query2);

        assertThat(getElement(query2).getText(),
                containsString(query2));
    }

    private WebElement getElement(String query) {
        return driver.findElement(By.xpath("//*[@id='index']/div[2]/ul/li[contains(text(),'" + query + "') and position()=1]"));
    }
}