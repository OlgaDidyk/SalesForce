package pages;

import components.AbstractComponent;
import components.otherComponents.buttons.NewButton;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;


public abstract class BasePage extends AbstractComponent {
    public BasePage(WebDriver driver) {
        super(driver);
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
        NewButton button = new NewButton(driver);
        button.clickNewButton();

    }

}
