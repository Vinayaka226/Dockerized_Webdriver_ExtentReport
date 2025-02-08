package tests.automationExercise;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;
import pageObjects.automationExercise.agent.HomePageAgent;
import tests.AbstractTest;

public class VerifyTestCasePage extends AbstractTest {

    private HomePageAgent homePage;
    @BeforeMethod
    public void setUpPage(){
        homePage = new HomePageAgent(driver);
    }

    @Test(groups = {"functional", "smoke"},
            attributes = {@CustomAttribute(name="Vinayaka")},
            description = "Verify Testcase Page")
    public void verifyTestCasePageTest(){
        homePage.goToHomePage()
                .clickTestCases()
                .assertTestCaseTitle();
    }
}
