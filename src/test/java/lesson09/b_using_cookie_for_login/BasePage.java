package lesson09.b_using_cookie_for_login;

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
