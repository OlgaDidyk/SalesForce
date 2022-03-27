package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountFormComponent extends AbstractComponent {

    private static final By HEADER = By.xpath("//h2[contains(., 'New Account')]");
    private static final By SAVE_BUTTON = By.xpath("//button[@title='Save']");

    public CreateAccountFormComponent(WebDriver driver) {
        super(driver);
    }


    public boolean isComponentDisplayed() {
        return isComponentDisplayed(HEADER);
    }


    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }

}
