package lesson10.a_we_wanna_get_screenshots_on_fails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends SimpleAPI {

    protected WebDriver driver;

    @Override
    WebDriver getWebDriver() {
        return driver;
    }

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
