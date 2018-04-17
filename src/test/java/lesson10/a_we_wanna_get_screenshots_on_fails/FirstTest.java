package lesson10.a_we_wanna_get_screenshots_on_fails;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
        assertThat(titleContains("My account1"));
    }
}