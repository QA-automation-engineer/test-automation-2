package lesson07.e_move_pageobject_to_separate_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    WebElement $(By locator){
        return driver.findElement(locator);
    }
}
