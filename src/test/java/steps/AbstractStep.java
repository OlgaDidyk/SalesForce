package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;

public class AbstractStep {
    WebDriver driver;

    public AbstractStep(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validation if page is loaded")
    protected void validatePageIsLoaded(BasePage page) {
        Assert.assertTrue(page.isPageLoaded(), page.getClass().getSimpleName().concat(" is not opened"));

    }
}
