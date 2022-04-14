package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import steps.AccountsSteps;
import steps.MainSteps;
import utils.TestListener;

import java.time.Duration;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    public static MainSteps mainSteps;
    protected AccountsSteps accountsSteps;


    @BeforeClass
    public void setUp(ITestContext iTestContext) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        setContextAttribute(iTestContext, "driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        mainSteps = new MainSteps(driver);
        accountsSteps = new AccountsSteps(driver);
    }

    private void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.close();
        driver.quit();
    }

}
