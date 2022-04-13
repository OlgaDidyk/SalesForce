package components.otherComponents.dropDowns.otherModulesDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpportunitiesDropDown extends DropDown {

    public static final By STAGE_DROPDOWN =
            By.xpath("//label[contains(., 'Stage')]/ancestor::slot[@name='inputField']//button[@type='button']");


    public OpportunitiesDropDown(WebDriver driver) {
        super(driver);
    }
}
