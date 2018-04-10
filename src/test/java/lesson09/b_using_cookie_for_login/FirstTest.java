package lesson09.b_using_cookie_for_login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

    private static final Logger LOG = LogManager.getLogger(FirstTest.class);

    LoginPage loginPage = new LoginPage(driver);
    @Test
    public void loginTest(){
        loginPage.visit();
        assertThat(titleContains("Login"));

        loginPage.login();
        assertThat(titleContains("My account"));

        Set<Cookie> cookies = driver.manage().getCookies();
        $(By.className("logout")).click();
        assertThat(titleContains("Login"));

        for(Cookie cookie : cookies){
            if(cookie.getName().contains("PrestaShop")){
                driver.manage().addCookie(cookie);
            } else {
                LOG.error("Ooops...");
            }
        }
        driver.navigate().refresh();
        assertThat(titleContains("My account"));
    }
}