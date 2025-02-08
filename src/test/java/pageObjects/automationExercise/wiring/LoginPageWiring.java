package pageObjects.automationExercise.wiring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

public class LoginPageWiring extends AbstractPage {

    public LoginPageWiring(WebDriver driver){
        super(driver);
    }

    private final String signUpForm = "div[class='signup-form']";
    private final String button = " button";
    private final String loginForm = "div[class='login-form'] ";

    @FindBy(css = signUpForm+" h2")
    protected WebElement signUpText;

    @FindBy(css = signUpForm+" input[name='name']")
    protected WebElement name;

    @FindBy(css = signUpForm+" input[name='email']")
    protected WebElement email;

    @FindBy(css = signUpForm+button)
    protected WebElement signUpButton;

    @FindBy(css = loginForm+"input[type='email']")
    protected WebElement loginEmail;

    @FindBy(css = loginForm+"input[type='password']")
    protected WebElement loginPassword;

    @FindBy(css = loginForm+button)
    protected WebElement loginButton;

    @Override
    public boolean pageReady() {
       this.wait.until(ExpectedConditions.visibilityOf(this.signUpButton));
       return this.signUpButton.isDisplayed();
    }
}
