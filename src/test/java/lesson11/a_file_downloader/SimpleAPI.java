package lesson11.a_file_downloader;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class SimpleAPI {

    abstract WebDriver getWebDriver();

    protected void open(String url){
        getWebDriver().get(url);
    }

    protected WebElement $(By locator){
        return assertThat(visibilityOfElementLocated(locator));
    }

    protected WebElement $(String xpath){
        return $(By.xpath(xpath));
    }

    protected List<WebElement> $$(By locator){
        return assertThat(visibilityOfAllElementsLocatedBy(locator));
    }

    protected void assertThat(ExpectedCondition<Boolean> condition){
        (new WebDriverWait(getWebDriver(), 10)).until(condition);
    }

    protected void assertThat(ExpectedCondition<Boolean> condition, int timeout){
        (new WebDriverWait(getWebDriver(), timeout)).until(condition);
    }

    protected  <V> V assertThat(Function<? super WebDriver, V> condition){
        return (new WebDriverWait(getWebDriver(), 10)).until(condition);
    }

    protected <V> V assertThat(Function<? super WebDriver, V> condition, int timeout){
        return (new WebDriverWait(getWebDriver(), timeout)).until(condition);
    }

    static {
        if(System.getProperty("report.path") == null){
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }
}
