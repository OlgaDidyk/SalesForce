package components.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpportunitiesForm extends BaseForm{

    public static final By HEADER = By.xpath("//h2[contains(., 'New Opportunity')]");
    public static final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");

    public OpportunitiesForm(WebDriver driver) {
        super(driver);
    }

/*    public boolean isFormDisplayed() {
        return isFormDisplayed(HEADER);
    }

    public void saveForm() {
        saveForm(SAVE_BUTTON);
    }*/
}
