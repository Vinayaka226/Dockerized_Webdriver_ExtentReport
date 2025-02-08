package pageObjects.automationExercise.agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageObjects.automationExercise.wiring.AccountCreatedPageWiring;

import static util.Commons.logsReporter;

public class AccountCreatedPageAgent extends AccountCreatedPageWiring {

    private static final Logger log = LoggerFactory.getLogger(AccountCreatedPageAgent.class);

    public AccountCreatedPageAgent(WebDriver driver) {
        super(driver);
        pageReady();
    }

    /**
     * Asserting if success message is displayed
     * @return AccountCreatedPageAgent
     */
    public AccountCreatedPageAgent assertAccountCreatedSuccessMessage(){
        String message = "ACCOUNT CREATED!";
        logsReporter("Asserting if success message: "+ message+" is displayed", log);
        Assert.assertEquals(this.createdMessage.getText(), message,
                    "Expected message to be: "+message+" but found "+this.createdMessage.getText());
        return this;
    }

    /**
     * Click 'Continue' button -> Navigate to Home Page
     * @return HomePageAgent
     */
    public HomePageAgent clickContinueButton(){
        logsReporter("Click 'Continue' button -> Navigate to Home Page", log);
        this.continueButton.click();
        HomePageAgent homePage = new HomePageAgent(driver);
        homePage.pageReady();
        return homePage;
    }
}
