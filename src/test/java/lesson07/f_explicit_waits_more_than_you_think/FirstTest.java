package lesson07.f_explicit_waits_more_than_you_think;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

    @Test
    public void firstResultShouldContainExpectedText(){
        String query1 = "Dress";
        String query2 = "T-shirt";
        MainPage mainPage = new MainPage(driver);
        mainPage.visit();

        mainPage.enterQuery(query1);
        assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query1));

        mainPage.enterQuery(query2);
        assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query2));
    }

    void assertThat(ExpectedCondition<Boolean> condition){
        (new WebDriverWait(driver, 10)).until(condition);
    }

    void assertThat(ExpectedCondition<Boolean> condition, int timeout){
        (new WebDriverWait(driver, timeout)).until(condition);
    }
}