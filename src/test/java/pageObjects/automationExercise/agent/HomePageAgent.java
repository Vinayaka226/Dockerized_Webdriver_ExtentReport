package pageObjects.automationExercise.agent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageObjects.automationExercise.wiring.HomePageWiring;
import util.Configuration;
import util.Constants;

import java.net.HttpURLConnection;
import java.net.URL;

import static util.Commons.logsReporter;


public class HomePageAgent extends HomePageWiring {

    private static final Logger log = LoggerFactory.getLogger(HomePageAgent.class);
    private static String autoTest = Configuration.getProperty(Constants.APPLICATION_URL);

    public HomePageAgent(WebDriver driver){
        super(driver);
    }

    public HomePageAgent goToHomePage(){
        logsReporter("Navigating to Page: "+Constants.APPLICATION_URL, log);
        this.driver.get(autoTest);
        pageReady();
        return this;
    }

    /**
     * Click on SignUp/Login and navigate to Login Page
     * @return LoginPageAgent
     */
    public LoginPageAgent clickSignUpLogin(){
        logsReporter("Clicking on Register/Login --> Navigate to Login page", log);
        WebElement login = this.topNavMenuLinks.stream()
                .filter(ele -> ele.getText().contains("Signup"))
                .findFirst()
                .orElse(null);
        Assert.assertEquals(login.getText(),"Signup / Login", "Asserting if Login is displayed");
        login.click();
        return new LoginPageAgent(driver);
    }

    /**
     * Assert UserName
     * @param userName - String
     * @return HomePageAgent
     */
    public HomePageAgent assertUserName(String userName){
        logsReporter("Asserting Username: "+userName+" is displayed after successful login", log);
        WebElement login = this.topNavMenuLinks.stream()
                .filter(ele -> ele.getText().contains("Logged in as"))
                .findFirst()
                .orElse(null);
        Assert.assertTrue(login.getText().contains(userName), "Expected User Name: "+userName+" is displayed");
        return this;
    }

    /**
     * Click on Logout button
     * @return LoginPageAgent
     */
    public LoginPageAgent clickLogout(){
        logsReporter("Clicking on Logout --> Navigate to Login page", log);
        WebElement logout = this.topNavMenuLinks.stream()
                        .filter( ele -> ele.getText().contains("Logout"))
                        .findFirst()
                        .orElse(null);
        Assert.assertEquals(logout.getText(),"Logout", "Asserting if Logout is displayed");
        logout.click();
        return new LoginPageAgent(driver);
    }

    /**
     * Clicking on Products --> Navigate to Products page
     * @return ProductsPageAgent
     */
    public ProductsPageAgent clickProductsButton(){
        logsReporter("Clicking on Products --> Navigate to Products page", log);
        WebElement products = this.topNavMenuLinks.stream()
                .filter( ele -> ele.getText().contains("Products"))
                .findFirst()
                .orElse(null);
        Assert.assertTrue(products.getText().contains("Products"), "Asserting if Products is displayed");
        products.click();
        return new ProductsPageAgent(driver);
    }

    /**
     * Clicking on Test Cases --> Navigate to Test Cases page
     * @return TestCasePageAgent
     */
    public TestCasePageAgent clickTestCases(){
        logsReporter("Clicking on Test Cases --> Navigate to Test Cases page", log);
        WebElement testCases = this.topNavMenuLinks.stream()
                .filter( ele -> ele.getText().contains("Test Cases"))
                .findFirst()
                .orElse(null);
        Assert.assertTrue(testCases.getText().contains("Test Cases"), "Asserting if Test Cases is displayed");
        testCases.click();
        return new TestCasePageAgent(driver);
    }

    /**
     * Clicking on Cart --> Navigate to Cart page
     * @return TestCasePageAgent
     */
    public CartPageAgent clickCart(){
        logsReporter("Clicking on Cart --> Navigate to Cart page", log);
        WebElement cart = this.topNavMenuLinks.stream()
                .filter( ele -> ele.getText().contains("Cart"))
                .findFirst()
                .orElse(null);
        Assert.assertTrue(cart.getText().contains("Cart"), "Asserting if Cart is displayed");
        cart.click();
        return new CartPageAgent(driver);
    }

    /**
     * Scroll to view Subscription
     * @return
     */
    public HomePageAgent scrollToViewSubscription() throws InterruptedException {
        logsReporter("Scroll to view Subscription", log);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", this.subscription);
        //((JavascriptExecutor)driver).executeScript("scroll(0,250)");
        Assert.assertTrue(this.subscription.isDisplayed());
        Thread.sleep(2000);
        return this;
    }

    public HomePageAgent scrollUpUsingArrowAtBottom(){
        logsReporter("Click on Scroll Up Arrow", log);
        this.scrollUp.click();
        return this;
    }

    public HomePageAgent assertHeaderLinks(){
        logsReporter("Assert if Header Links are broken", log);
        this.topNavMenuLinks.stream()
                .map( ele -> ele.getAttribute("href"))
                .forEach(e ->
                        {
                            //System.out.println("##################"+getResponseCode(e) +" :: "+e);
                            Assert.assertNotEquals(getResponseCode(e), 404);
                        });
        return this;
    }
    /**
     * Returns the HTTP response code
     * @param link - String
     * @return Integer - Response code
     */
    private static int getResponseCode(String link) {
        URL url;
        HttpURLConnection con = null;
        Integer responsecode = 0;
        try {
            url = new URL(link);
            con = (HttpURLConnection) url.openConnection();
            responsecode = con.getResponseCode();
        } catch (Exception e) {
            // skip
        } finally {
            if (null != con)
                con.disconnect();
        }
        return responsecode;
    }
}
