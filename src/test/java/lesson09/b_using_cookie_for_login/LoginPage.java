package lesson09.b_using_cookie_for_login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CredsManager;

public class LoginPage extends BasePage {
    private static final Logger LOG = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(){
        $(By.id("email")).sendKeys(CredsManager.getCred("username"));
        $(By.id("passwd")).sendKeys(CredsManager.getCred("passwd"));
        $(By.id("SubmitLogin")).click();
    }

    private void setValue(WebElement element, String value){
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void visit(){
        open("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
}
