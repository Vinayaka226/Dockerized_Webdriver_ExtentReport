package tests.automationExercise;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;
import pageObjects.automationExercise.agent.HomePageAgent;
import tests.AbstractTest;

public class VerifyScrollDownScrollUp extends AbstractTest {

    private HomePageAgent homePage;
    @BeforeMethod
    public void setUpPage(){
        homePage = new HomePageAgent(driver);
    }

    @Test(groups = {"functional", "smoke"},
            attributes = {@CustomAttribute(name="Vinayaka")},
            description = "Validate Scroll Down and Up")
    public void verifyScrollTest() throws InterruptedException {
        homePage.goToHomePage()
                .scrollToViewSubscription()
                .scrollUpUsingArrowAtBottom();
    }
}
