package lesson08.c_browser_loggs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

    private static final Logger LOG = LogManager.getLogger(FirstTest.class);
    @Ignore
    @Test
    public void firstResultShouldContainExpectedText(){
        String query1 = "Dress";
        String query2 = "T-shirt";
        MainPage mainPage = new MainPage(driver);
        LOG.info("Visit main page.");
        mainPage.visit();
        assertThat(new ExpectedCondition<Boolean> () {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().equals("My Store");
            }
        });
        LOG.info("Entering first query.");
        mainPage.enterQuery(query1);
        LOG.debug("Checking 1.");
        assertThat(CustomExpectedCondition.listShouldHaveSize(mainPage.ADVICE_LOCATOR, 7));
        assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query1));
        LOG.info("Entering second query.");
        mainPage.enterQuery(query2);
        LOG.debug("Checking 2.");
        assertThat(CustomExpectedCondition.listShouldHaveSize(mainPage.ADVICE_LOCATOR, 1));
        assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query2));
    }

    @Test
    public void test_warning(){
        open("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        assertThat(ExpectedConditions.titleContains("Login"));
        Logs logs = getWebDriver().manage().logs();
        LogEntries logEntries = logs.get(LogType.BROWSER);

        for (LogEntry logEntry : logEntries) {
            String logMessage = logEntry.getMessage();
            if (logMessage.contains("credit card")) {
                LOG.info(logMessage);
            }
        }
    }


}