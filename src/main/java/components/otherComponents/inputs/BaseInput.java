package components.otherComponents.inputs;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseInput extends AbstractComponent {


    public String label;
    public By accountInputLocator;
    public By contactInputLocator;


    public BaseInput(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

}
