package lesson11.a_file_downloader;

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
