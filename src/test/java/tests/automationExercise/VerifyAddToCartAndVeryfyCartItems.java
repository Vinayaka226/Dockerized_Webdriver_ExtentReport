package tests.automationExercise;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;
import pageObjects.automationExercise.agent.HomePageAgent;
import tests.AbstractTest;

public class VerifyAddToCartAndVeryfyCartItems extends AbstractTest {

    private HomePageAgent homePage;
    @BeforeMethod
    public void setUpPage(){
        homePage = new HomePageAgent(driver);
    }

    @Test(groups = {"functional"},
            attributes = {@CustomAttribute(name="Vinayaka")},
            description = "Validate Add To Cart Functionality")
    public void verifyAllProductsTest(){
        homePage.goToHomePage()
                .clickProductsButton()
                .addFirstProductToCart()
                .clickContinueShoppingOnModalContent()
                .addNthProductToCart(1)
                .clickContinueShoppingOnModalContent();
        homePage.goToHomePage()
                .clickCart()
                .assertCartItems(2);
    }
}
