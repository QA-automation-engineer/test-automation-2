package lesson10.a_we_wanna_get_screenshots_on_fails;

import org.openqa.selenium.WebDriver;

class MainPage extends BasePage implements MainPageLocators {

    private WebDriver driver;

    MainPage(WebDriver driver) {
        super(driver);
    }

    void enterQuery(String query){
        $(FIELD_QUERY_LOCATOR).click();
        $(FIELD_QUERY_LOCATOR).clear();
        $(FIELD_QUERY_LOCATOR).sendKeys(query);
    }

    void visit(){
        open("http://automationpractice.com/index.php");
    }

}
