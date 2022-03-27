package components.buttons.menu;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public abstract class MenuButton extends AbstractComponent {

    private static final String BUTTON_LOCATOR_PATTERN = "//one-app-nav-bar-item-root/a[@title='%s']";
    private String label;
    public static By buttonLocator;


    public MenuButton(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.buttonLocator = By.xpath(String.format(BUTTON_LOCATOR_PATTERN, label));
    }

    public void click() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(buttonLocator));
    }

}
