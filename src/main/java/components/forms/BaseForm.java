package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseForm extends AbstractComponent {

    public BaseForm(WebDriver driver) {
        super(driver);
    }

    public boolean isFormDisplayed(By header) {
        return isComponentDisplayed(header);
    }

    public void saveForm(By saveButton) {
        driver.findElement(saveButton).click();
    }

}
