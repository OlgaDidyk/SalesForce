package components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractComponent {

    protected static WebDriver driver;
    protected WebDriverWait explicitlyWait;
    public static Logger log = LogManager.getLogger();


    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public boolean isComponentDisplayed(By element) {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

}
