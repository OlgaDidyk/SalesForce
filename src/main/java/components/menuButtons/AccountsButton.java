package components.menuButtons;

import org.openqa.selenium.WebDriver;

public class AccountsButton extends MenuButton {

    public static final String ACCOUNT_BUTTON_LABEL = "Accounts";

    public AccountsButton(WebDriver driver) {
        super(driver, ACCOUNT_BUTTON_LABEL);
    }
}
