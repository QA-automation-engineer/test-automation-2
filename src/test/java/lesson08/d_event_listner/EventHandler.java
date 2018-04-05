package lesson08.d_event_listner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class EventHandler extends AbstractWebDriverEventListener {
    private static final Logger LOG = LogManager.getLogger(EventHandler.class);

    public EventHandler() {
        super();
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        LOG.debug("Navigate to URL: " + url);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        LOG.debug("Finding element with loc: " + by);
    }
}
