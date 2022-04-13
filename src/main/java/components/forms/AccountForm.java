package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountForm extends BaseForm {

    public static final By HEADER = By.xpath("//h2[contains(., 'New Account')]");
    public static final By SAVE_BUTTON = By.xpath("//button[@title='Save']");

    public AccountForm(WebDriver driver) {
        super(driver);
    }

/*    public boolean isFormDisplayed() {
        return isFormDisplayed(HEADER);
    }

    public void saveForm() {
        saveForm(SAVE_BUTTON);
    }*/

}
