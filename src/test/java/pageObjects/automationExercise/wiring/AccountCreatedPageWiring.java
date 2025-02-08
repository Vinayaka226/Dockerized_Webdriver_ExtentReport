package pageObjects.automationExercise.wiring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

public class AccountCreatedPageWiring extends AbstractPage {

    public AccountCreatedPageWiring(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2 b")
    protected WebElement createdMessage;

    @FindBy(css = "a[class*='btn-primary']")
    protected WebElement continueButton;

    @Override
    public boolean pageReady() {
        this.wait.until(ExpectedConditions.visibilityOf(this.continueButton));
        return this.continueButton.isDisplayed();
    }
}
