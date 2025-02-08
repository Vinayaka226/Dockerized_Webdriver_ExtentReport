package tests.automationExercise;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;
import pageObjects.automationExercise.agent.HomePageAgent;
import pageObjects.automationExercise.records.UserDetailsRecord;
import tests.AbstractTest;
import util.JSONUtil;

public class HeaderLinkTest extends AbstractTest {

    private HomePageAgent homePage;
    @BeforeMethod
    public void setUpPage(){
        homePage = new HomePageAgent(driver);
    }

    @Test(groups = {"functional", "sanity"},
            attributes = {@CustomAttribute(name="Vinayaka B M")},
            description = "Validate Links in Header Section")
    public void verifyHeaderLinkTest(){
        homePage.goToHomePage()
                .assertHeaderLinks();
    }
}
