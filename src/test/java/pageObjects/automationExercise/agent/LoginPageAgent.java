package pageObjects.automationExercise.agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.automationExercise.wiring.LoginPageWiring;
import util.Constants;

import static util.Commons.logsReporter;

public class LoginPageAgent extends LoginPageWiring {

    private static final Logger log = LoggerFactory.getLogger(LoginPageAgent.class);

    public LoginPageAgent(WebDriver driver){
        super(driver);
        pageReady();
    }

    /**
     * Type the name
     * @param name - String name
     * @return LoginPageAgent
     */
    public LoginPageAgent enterName(String name){
        logsReporter("Entering the Name: "+name, log);
        this.name.sendKeys(name);
        return this;
    }

    /**
     * Type the email
     * @param email - String email
     * @return LoginPageAgent
     */
    public LoginPageAgent enterEmail(String email){
        logsReporter("Entering the Email: "+email, log);
        this.email.sendKeys(email);
        return this;
    }

    /**
     *Clicking on Signup Button --> Navigate to SignUp Page
     * @return SignupPageAgent
     */
    public SignupPageAgent clickSignUpButton(){
        logsReporter("Clicking on Signup Button --> Navigate to SignUp Page", log);
        this.signUpButton.click();
        return new SignupPageAgent(driver);
    }

    /**
     * Type the Login email
     * @param email - String email
     * @return LoginPageAgent
     */
    public LoginPageAgent enterLoginEmail(String email){
        logsReporter("Entering the Login Email: "+email, log);
        this.loginEmail.sendKeys(email);
        return this;
    }

    /**
     * Type the Login Password
     * @param password - String password
     * @return LoginPageAgent
     */
    public LoginPageAgent enterLoginPassword(String password){
        logsReporter("Entering the Login password: "+email, log);
        this.loginPassword.sendKeys(password);
        return this;
    }

    /**
     *Clicking on Login Button --> Navigate to HomePage
     * @return HomePageAgent
     */
    public HomePageAgent clickLoginButton(){
        logsReporter("Clicking on Login Button --> Navigate to Home Page", log);
        this.loginButton.click();
        return new HomePageAgent(driver);
    }
}
