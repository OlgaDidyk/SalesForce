package components.otherComponents.buttons;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewButton extends AbstractComponent {

    public static final By NEW_BUTTON = By.cssSelector("a[title='New']");

    public NewButton(WebDriver driver) {
        super(driver);
    }

    public void clickNewButton() {
        driver.findElement(NEW_BUTTON).click();
    }
}
