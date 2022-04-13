package components.otherComponents.inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsInput extends BaseInput {

    private static final String ACCOUNT_INPUT_LOCATOR_PATTERN =
            "//label[contains(., '%s')]/ancestor::div[contains(@class,'uiInput')]//input";

    public By accountInputLocator = By.xpath(String.format(ACCOUNT_INPUT_LOCATOR_PATTERN, label));


    public AccountsInput(WebDriver driver, String label) {
        super(driver, label);
    }

    public void insert(String text) {
        accountInputLocator = By.xpath(String.format(ACCOUNT_INPUT_LOCATOR_PATTERN, label));
        driver.findElement(accountInputLocator).sendKeys(text);
    }

}
