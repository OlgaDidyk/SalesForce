package pages;

import components.AbstractComponent;
import components.otherComponents.Buttons;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebDriver;

import java.time.Duration;


public abstract class BasePage extends AbstractComponent {

    //TODO это расширенная версия АбстрактКомпонента
    WebDriver driver;
    WebDriverWait explicitlyWait;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    abstract public void waitPageLoaded();

    abstract public BasePage openPage();

    public boolean isPageLoaded() {
        log.info("Loading a page");
        try {
            waitPageLoaded();
        } catch (TimeoutException ex) {
            System.out.println("EXCEPTION HAS BEEN CAUGHT");
            return false;
        }
        return true;
    }

    public void openNewForm() {
        log.info("Opening a form");
        Buttons buttons = new Buttons(driver);
        buttons.clickNewButton();

    }

}
