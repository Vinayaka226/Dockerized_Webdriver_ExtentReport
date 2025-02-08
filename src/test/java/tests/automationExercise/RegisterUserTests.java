package tests.automationExercise;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;
import pageObjects.automationExercise.agent.HomePageAgent;
import pageObjects.automationExercise.records.UserDetailsRecord;
import tests.AbstractTest;
import util.JSONUtil;

import static util.RandomGenerator.getUniqueId;

public class RegisterUserTests extends AbstractTest {

    private HomePageAgent homePage;
    private UserDetailsRecord userDet;
    private String name;
    private String email;

    @BeforeMethod
    public void setUpPage(){
        homePage = new HomePageAgent(driver);
        userDet = JSONUtil.getData(testDataPath+"userDetails1.json", UserDetailsRecord.class);
    }

    @Test(groups = {"functional", "smoke"},
            attributes = {@CustomAttribute(name="Vinayaka B M")},
            description = "Validate Register functionality")
    public void registerTest() throws InterruptedException {

        name = userDet.name()+ getUniqueId();
        email = name+userDet.email();

        homePage.goToHomePage()
                .clickSignUpLogin()
                .enterName(name)
                .enterEmail(email)
                .clickSignUpButton()
                .assertNameDisplayedCorrectly(name)
                .assertEmailDisplayedCorrectly(email)
                .typePassword(userDet.password())
                .selectDay(userDet.day())
                .selectMonth(userDet.month())
                .selectYear(userDet.year())
                .typeFirstName(name)
                .typeLastName(name)
                .typeAddress(userDet.address1())
                .typeState(userDet.state())
                .typeCity(userDet.city())
                .typeZip(userDet.zip())
                .typeMobileNumber(userDet.mobile())
                .clickCreateAccount()
                .assertAccountCreatedSuccessMessage()
                .clickContinueButton()
                .assertUserName(name);
    }

    @Test(groups = {"functional", "Smoke"},
            dependsOnMethods = {"registerTest"},
            attributes = {@CustomAttribute(name="Vinayaka B M")},
            description = "Validate Logout functionality")
    public void logoutTest(){
        homePage.clickLogout();
    }

    @Test(groups = {"functional", "Smoke"},
            dependsOnMethods = {"logoutTest"},
            attributes = {@CustomAttribute(name="Vinayaka")},
            description = "Validate Login functionality")
    public void loginTest(){
        homePage.goToHomePage()
                .clickSignUpLogin()
                .enterLoginEmail(email)
                .enterLoginPassword(userDet.password())
                .clickLoginButton()
                .assertUserName(name);
    }
}
