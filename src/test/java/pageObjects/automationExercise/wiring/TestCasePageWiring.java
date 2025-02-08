package pageObjects.automationExercise.wiring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

public class TestCasePageWiring extends AbstractPage {

    public TestCasePageWiring(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[contains(@class,'title')]")
    protected WebElement title;

    @Override
    public boolean pageReady() {
        this.wait.until(ExpectedConditions.visibilityOf(this.title));
        return this.title.isDisplayed();
    }
}
