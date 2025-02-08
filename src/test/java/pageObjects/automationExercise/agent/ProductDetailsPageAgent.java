package pageObjects.automationExercise.agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageObjects.automationExercise.wiring.ProductDetailsPageWiring;

import static util.Commons.logsReporter;

public class ProductDetailsPageAgent extends ProductDetailsPageWiring {

    private static final Logger log = LoggerFactory.getLogger(ProductDetailsPageAgent.class);
    public ProductDetailsPageAgent(WebDriver driver) {
        super(driver);
        pageReady();
    }

    /**
     * Asserting if 'Product Name' is displayed
     * @return ProductDetailsPageAgent
     */
    public ProductDetailsPageAgent assertProductNameDisplayed(){
        logsReporter("Asserting if 'Product Name' is displayed", log);
        Assert.assertTrue(this.productName.isDisplayed());
        return this;
    }

    /**
     * Asserting if 'Product Availability' is displayed
     * @return ProductDetailsPageAgent
     */
    public ProductDetailsPageAgent assertProductAvailabilityDisplayed(){
        logsReporter("Asserting if 'Product Availability' is displayed", log);
        Assert.assertTrue(this.availability.getText().contains("In Stock"));
        return this;
    }

    /**
     * Asserting if 'Product Condition' is displayed
     * @return ProductDetailsPageAgent
     */
    public ProductDetailsPageAgent assertProductConditionDisplayed(){
        logsReporter("Asserting if 'Product Condition' is displayed", log);
        Assert.assertTrue(this.condition.getText().contains("New"));
        return this;
    }

    /**
     * Asserting if 'Product Brand' is displayed
     * @return ProductDetailsPageAgent
     */
    public ProductDetailsPageAgent assertProductBrandDisplayed(){
        logsReporter("Asserting if 'Product Brand' is displayed", log);
        Assert.assertTrue(this.brand.getText().contains("Polo"));
        return this;
    }
}
