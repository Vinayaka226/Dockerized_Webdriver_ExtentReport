package tests.automationExercise;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;
import pageObjects.automationExercise.agent.HomePageAgent;
import tests.AbstractTest;

public class VerifySearchProduct extends AbstractTest {

    private HomePageAgent homePage;
    @BeforeMethod
    public void setUpPage(){
        homePage = new HomePageAgent(driver);
    }

    @Test(groups = {"functional", "smoke"},
            attributes = {@CustomAttribute(name="Vinayaka")},
            description = "Validate Product Search Feature")
    public void verifyAllProductsTest(){
        homePage.goToHomePage()
                .clickProductsButton()
                .assertAllProductsDisplayed()
                .enterProductSearchQuery("Top")
                .clickSearch()
                .assertProductInfoContainsText("Top");
    }
}
