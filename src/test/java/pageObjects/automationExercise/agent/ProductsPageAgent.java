package pageObjects.automationExercise.agent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageObjects.automationExercise.wiring.ProductsPageWiring;
import util.Commons;


import static util.Commons.logsReporter;

public class ProductsPageAgent extends ProductsPageWiring {

    private static final Logger log = LoggerFactory.getLogger(ProductsPageAgent.class);
    private static Actions action;

    public ProductsPageAgent(WebDriver driver) {
        super(driver);
        pageReady();
    }

    /**
     * Asserting if 'ALL PRODUCTS' is displayed
     * @return ProductsPageAgent
     */
    public ProductsPageAgent assertAllProductsDisplayed(){
        String message = "ALL PRODUCTS";
        logsReporter("Asserting if '"+message+"' is displayed ", log);
        Assert.assertEquals(this.allProductsHeader.getText(), message,
                        "Expected to find: "+message+" but it was missing");
        return this;
    }

    /**
     * Asserting if Products List displayed
     * @return ProductsPageAgent
     */
    public ProductsPageAgent assertProductsListDisplayed(){
        logsReporter("Asserting if Products List displayed", log);
        Assert.assertTrue(this.product_details.size() > 25,
                "Expected to find Products List > 25 but it as not");
        return this;
    }

    /**
     * Click on first product -> navigate to Product details page
     * @return ProductDetailsPageAgent
     */
    public ProductDetailsPageAgent clickOnFirstProduct(){
        logsReporter("Click on first product -> navigate to Product details page", log);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", this.product_details.getFirst());
        this.product_details.getFirst().click();
        return new ProductDetailsPageAgent(driver);
    }

    /**
     * Search for a product
     * @param productInfo - String
     * @return ProductsPageAgent
     */
    public ProductsPageAgent enterProductSearchQuery(String productInfo){
        logsReporter("Typing "+productInfo+" to search for the product", log);
        this.searchProductField.sendKeys(productInfo);
        return this;
    }

    /**
     * Click Search to search for products
     * @return ProductsPageAgent
     */
    public ProductsPageAgent clickSearch(){
        logsReporter("Click Search to search for products", log);
        this.submitSearch.click();
        return this;
    }

    /**
     * Asserting if 'SEARCHED PRODUCTS' is displayed
     * @return ProductsPageAgent
     */
    public ProductsPageAgent assertSearchedProductsDisplayed(){
        String message = "SEARCHED PRODUCTS";
        logsReporter("Asserting if '"+message+"' is displayed ", log);
        Assert.assertEquals(this.allProductsHeader.getText(), message,
                "Expected to find: "+message+" but it was missing");
        return this;
    }

    /**
     * Asserting if searched text is displayed in product info
     * @param text - String
     * @return
     */
    public ProductsPageAgent assertProductInfoContainsText(String text){
        logsReporter("Asserting if searched text '"+text+"' is displayed in product info", log);
        boolean flag = true;
        for(WebElement ele : this.productInfo){
            if(!ele.getText().contains(text)){
                flag = false;
                break;
            }
             else continue;
        }
        if(!flag)
            Assert.assertFalse(flag, "Did not find text: "+text+" in the Searched product info");
        return this;
    }

    /**
     * Click on first product -> Add To Cart
     * @return ProductDetailsPageAgent
     */
    public ProductsPageAgent addFirstProductToCart(){
        logsReporter("Click on first product -> Add To Cart", log);
        action = new Actions(driver);
        Commons.hoverOverElementAndClick(action,this.addToCart.getFirst());
        return this;
    }

    /**
     * Click on Nth product -> Add To Cart
     * @return ProductDetailsPageAgent
     */
    public ProductsPageAgent addNthProductToCart(int index){
        logsReporter("Click on Nth product index: "+index+" -> Add To Cart", log);
        action = new Actions(driver);
        Commons.hoverOverElementAndClick(action,this.addToCart.get(index));
        return this;
    }

    /**
     * Click Continue Shopping on Modal Content
     * @return ProductsPageAgent
     */
    public ProductsPageAgent clickContinueShoppingOnModalContent(){
        logsReporter("Click Continue Shopping on Modal Content", log);
        this.wait.until(ExpectedConditions.visibilityOf(this.modalContentButton));
        this.modalContentButton.click();
        return this;
    }
}
