package tests.automationExercise;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;
import pageObjects.automationExercise.agent.HomePageAgent;
import tests.AbstractTest;

public class VerifyAllProductsAndProductsDetails extends AbstractTest {

    private HomePageAgent homePage;
    @BeforeMethod
    public void setUpPage(){
        homePage = new HomePageAgent(driver);
    }

    @Test(groups = {"functional"},
            attributes = {@CustomAttribute(name="Vinayaka")},
            description = "Validate Logout functionality")
    public void verifyAllProductsTest(){
        homePage.goToHomePage()
                .clickProductsButton()
                .assertAllProductsDisplayed()
                .assertProductsListDisplayed()
                .clickOnFirstProduct()
                .assertProductBrandDisplayed()
                .assertProductAvailabilityDisplayed()
                .assertProductConditionDisplayed()
                .assertProductBrandDisplayed();
    }
}
