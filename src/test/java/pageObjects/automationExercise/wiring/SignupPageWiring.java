package pageObjects.automationExercise.wiring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

public class SignupPageWiring extends AbstractPage {

    public SignupPageWiring(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "id_gender1")
    protected WebElement titleMale;

    @FindBy(id = "id_gender2")
    protected WebElement titleFemale;

    @FindBy(id = "password")
    protected WebElement password;

    @FindBy(id = "name")
    protected WebElement name;

    @FindBy(id = "email")
    protected WebElement email;

    @FindBy(id = "days")
    protected WebElement day;

    @FindBy(id = "months")
    protected WebElement month;

    @FindBy(id = "years")
    protected WebElement year;

    @FindBy(id = "first_name")
    protected WebElement first_name;

    @FindBy(id = "last_name")
    protected WebElement last_name;

    @FindBy(id = "address1")
    protected WebElement address1;

    @FindBy(id = "country")
    protected WebElement country;

    @FindBy(id = "state")
    protected WebElement state;

    @FindBy(id = "city")
    protected WebElement city;

    @FindBy(id = "zipcode")
    protected WebElement zipcode;

    @FindBy(id = "mobile_number")
    protected WebElement mobile_number;

    @FindBy(css = "button[data-qa='create-account']")
    protected WebElement create_account;

    @FindBy(css = "div[class*='footer-widget'] div div")
    protected WebElement footer;

    @Override
    public boolean pageReady() {
        this.wait.until(ExpectedConditions.visibilityOf(this.create_account));
        return this.create_account.isDisplayed();
    }
}
