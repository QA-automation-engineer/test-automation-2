package lesson07.h_custom_conditions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

    @Test
    public void firstResultShouldContainExpectedText(){
        String query1 = "Dress";
        String query2 = "T-shirt";
        MainPage mainPage = new MainPage(driver);
        mainPage.visit();
        assertThat(new ExpectedCondition<Boolean> () {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().equals("My Store");
            }
        });

        mainPage.enterQuery(query1);
        assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query1));

        mainPage.enterQuery(query2);
        assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query2));
    }
}