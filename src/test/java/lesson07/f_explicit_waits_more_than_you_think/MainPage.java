package lesson07.f_explicit_waits_more_than_you_think;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

class MainPage implements MainPageLocators {

    private WebDriver driver;

    MainPage(WebDriver driver) {
        this.driver = driver;
    }

    void enterQuery(String query){
        $(FIELD_QUERY_LOCATOR).click();
        $(FIELD_QUERY_LOCATOR).clear();
        $(FIELD_QUERY_LOCATOR).sendKeys(query);
    }

    void visit(){
        driver.get("http://automationpractice.com/index.php");
    }

//    WebElement $(By locator){
//        return driver.findElement(locator);
//    }

    WebElement $(By locator){
        return assertThat(visibilityOfElementLocated(locator));
    }

    private <V> V assertThat(Function<? super WebDriver, V> condition){
        return (new WebDriverWait(driver, 10)).until(condition);
    }

    private <V> V assertThat(Function<? super WebDriver, V> condition, int timeout){
        return (new WebDriverWait(driver, timeout)).until(condition);
    }
}
