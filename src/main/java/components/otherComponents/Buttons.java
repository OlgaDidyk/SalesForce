package components.otherComponents;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Buttons extends AbstractComponent {

    public static final By NEW_BUTTON = By.cssSelector("a[title='New']");

    public Buttons(WebDriver driver) {
        super(driver);
    }

    public void clickNewButton() {
        driver.findElement(NEW_BUTTON).click();
    }
}
