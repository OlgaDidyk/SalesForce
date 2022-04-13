package components.otherComponents.dropDowns;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseDropDown extends AbstractComponent {

    public By dropdownLocator;

    public BaseDropDown(WebDriver driver) {
        super(driver);
    }

    public void openOptionsPopup(By locator) {
        driver.findElement(locator).click();
    }
}
