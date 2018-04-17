package lesson10.a_we_wanna_get_screenshots_on_fails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class CustomExpectedCondition {

    public static ExpectedCondition<List<WebElement>> listShouldHaveSize(By locator, int expSize){

        return new ExpectedCondition<List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver driver) {
                List<WebElement> list = driver.findElements(locator);
                return list.size() == expSize ? list : null;
            }
        };
    }
}
