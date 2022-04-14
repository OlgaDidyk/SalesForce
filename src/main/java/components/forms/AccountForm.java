package components.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountForm extends BaseForm {

    public static final By HEADER = By.xpath("//h2[contains(., 'New Account')]");
    public static final By SAVE_BUTTON = By.xpath("//button[@title='Save']");

    public AccountForm(WebDriver driver) {
        super(driver);
    }

}
