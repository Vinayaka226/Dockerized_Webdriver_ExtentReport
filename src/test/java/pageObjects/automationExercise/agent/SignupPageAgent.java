package pageObjects.automationExercise.agent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageObjects.automationExercise.wiring.SignupPageWiring;
import util.Commons;
import util.Constants;

import static util.Commons.logsReporter;

public class SignupPageAgent extends SignupPageWiring {

    private static final Logger log = LoggerFactory.getLogger(SignupPageAgent.class);
    public SignupPageAgent(WebDriver driver) {
        super(driver);
        pageReady();
    }

    /**
     * Asserting if the Displayed name matches expected value
     * @param expectedName - String
     * @return SignupPageAgent
     */
    public SignupPageAgent assertNameDisplayedCorrectly(String expectedName){
        logsReporter("Asserting if the Displayed name matches: "+ expectedName, log);
        Assert.assertEquals(this.name.getAttribute("value"), expectedName, "if the Displayed name matches: "+expectedName+" but it did not");
        return this;
    }

    /**
     * Asserting if the Displayed email matches expected value
     * @param expectedEmail - String
     * @return SignupPageAgent
     */
    public SignupPageAgent assertEmailDisplayedCorrectly(String expectedEmail){
        logsReporter("Asserting if the Displayed email matches: "+ expectedEmail, log);
        Assert.assertEquals(this.email.getAttribute("value"), expectedEmail, "if the Displayed email matches: "+expectedEmail+" but it did not");
        return this;
    }

    /**
     * Selecting Title based on Gender
     * @param gender - String Possible Values => [Male/Female]
     * @return SignupPageAgent
     */
    public SignupPageAgent selectTitle(String gender){
        logsReporter("Selecting Title based on Gender: "+ gender, log);
        if (gender.equals("Male"))
            this.titleMale.click();
         else
            this.titleFemale.click();
        return this;
    }

    /**
     *Typing the password
     * @param password - String
     * @return SignupPageAgent
     */
    public SignupPageAgent typePassword(String password){
        logsReporter("Typing the password: "+ password, log);
        this.password.sendKeys(password);
        return this;
    }

    /**
     * Selecting Day from dropdown
     * @param day - String
     * @return SignupPageAgent
     */
    public SignupPageAgent selectDay(String day){
        logsReporter("Selecting from dropdown :: Day: "+ day, log);
        Commons.dropdownSelectVisibleText(this.day,day);
        return this;
    }

    /**
     * Selecting Month from dropdown
     * @param month - String
     * @return SignupPageAgent
     */
    public SignupPageAgent selectMonth(String month){
        logsReporter("Selecting from dropdown :: Month: "+ month, log);
        Commons.dropdownSelectVisibleText(this.month,month);
        return this;
    }

    /**
     * Selecting Year from dropdown
     * @param year - String
     * @return SignupPageAgent
     */
    public SignupPageAgent selectYear(String year){
        logsReporter("Selecting from dropdown :: Year: "+ year, log);
        Commons.dropdownSelectVisibleText(this.year,year);
        return this;
    }

    /**
     *Typing the First Name
     * @param fname - String
     * @return SignupPageAgent
     */
    public SignupPageAgent typeFirstName(String fname){
        logsReporter("Typing the First Name: "+ fname, log);
        this.first_name.sendKeys(fname);
        return this;
    }

    /**
     *Typing the Last Name
     * @param lname - String
     * @return SignupPageAgent
     */
    public SignupPageAgent typeLastName(String lname){
        logsReporter("Typing the Last Name: "+ lname, log);
        this.last_name.sendKeys(lname);
        return this;
    }

    /**
     *Typing the Address 1
     * @param address - String
     * @return SignupPageAgent
     */
    public SignupPageAgent typeAddress(String address){
        logsReporter("Typing the address: "+ address, log);
        this.address1.sendKeys(address);
        return this;
    }

    /**
     *Typing the State
     * @param state - String
     * @return SignupPageAgent
     */
    public SignupPageAgent typeState(String state){
        logsReporter("Typing the State: "+ state, log);
        this.state.sendKeys(state);
        return this;
    }

    /**
     *Typing the City
     * @param city - String
     * @return SignupPageAgent
     */
    public SignupPageAgent typeCity(String city){
        logsReporter("Typing the State: "+ city, log);
        this.city.sendKeys(city);
        return this;
    }

    /**
     * Typing the zip
     * @param zip - String
     * @return SignupPageAgent
     */
    public SignupPageAgent typeZip(String zip){
        logsReporter("Typing the Zip: "+ zip, log);
        this.zipcode.sendKeys(zip);
        return this;
    }

    /**
     * Typing the mobile number
     * @param mobile - String
     * @return SignupPageAgent
     */
    public SignupPageAgent typeMobileNumber(String mobile){
        logsReporter("Typing the Mobile Number: "+ mobile, log);
        this.mobile_number.sendKeys(mobile);
        return this;
    }

    /**
     * Clicking Create Account -> Navigating to Account Created Page
     * @return SignupPageAgent
     */
    public AccountCreatedPageAgent clickCreateAccount() throws InterruptedException {
        logsReporter("Clicking Create Account -> Navigating to Account Created Page", log);
        Actions action = new Actions(driver);
        action.moveToElement(this.footer);
        action.moveToElement(this.create_account);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.create_account));
        Thread.sleep(1000);
        this.create_account.click();
        return new AccountCreatedPageAgent(driver);
    }
}
