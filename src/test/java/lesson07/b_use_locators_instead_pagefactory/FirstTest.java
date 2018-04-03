package lesson07.b_use_locators_instead_pagefactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void firstResultShouldContainExpectedText(){
        String query1 = "Dress";
        String query2 = "T-shirt";
        MainPage mainPage = new MainPage(driver);

        mainPage.enterQuery(query1);
        (new WebDriverWait(driver, 10))
                .until(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query1));

        mainPage.enterQuery(query2);
        (new WebDriverWait(driver, 10))
                .until(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query2));
    }

    class MainPage implements MainPageLocators{

        private WebDriver driver;

        MainPage(WebDriver driver) {
            this.driver = driver;
        }

        void enterQuery(String query){
            driver.findElement(FIELD_QUERY_LOCATOR).click();
            driver.findElement(FIELD_QUERY_LOCATOR).clear();
            driver.findElement(FIELD_QUERY_LOCATOR).sendKeys(query);
        }
    }
}