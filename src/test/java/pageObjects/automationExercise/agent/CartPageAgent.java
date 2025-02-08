package pageObjects.automationExercise.agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageObjects.automationExercise.wiring.CartPageWiring;

import static util.Commons.logsReporter;

public class CartPageAgent extends CartPageWiring {

    private static final Logger log = LoggerFactory.getLogger(CartPageAgent.class);

    public CartPageAgent(WebDriver driver) {
        super(driver);
        pageReady();
    }

    /**
     * Asserting if Cart contains Expected items count
     * @param expectedCount
     */
    public void assertCartItems(int expectedCount){
        logsReporter("Asserting if Cart contains Expected items count: "+expectedCount, log);
        Assert.assertEquals(this.cartItems.size(),expectedCount);
    }
}
