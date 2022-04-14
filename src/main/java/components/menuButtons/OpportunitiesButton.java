package components.menuButtons;

import org.openqa.selenium.WebDriver;

public class OpportunitiesButton extends MenuButton {

    public static final String OPPORTUNITIES_BUTTON_LABEL = "Opportunities";

    public OpportunitiesButton(WebDriver driver) {
        super(driver, OPPORTUNITIES_BUTTON_LABEL);
    }
}
