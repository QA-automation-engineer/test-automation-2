package lesson08.d_event_listner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest extends SimpleAPI {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        EventFiringWebDriver wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new EventHandler());
        driver = wd;
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Override
    WebDriver getWebDriver() {
        return driver;
    }

    static {
        if(System.getProperty("report.path") == null){
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }
}
