package pageObjects.automationExercise.wiring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

import java.util.List;

public class ProductsPageWiring extends AbstractPage {
    public ProductsPageWiring(WebDriver driver) {
        super(driver);
    }

    private final String items = "div[class*='productinfo'] ";

    @FindBy(css = "div[class*='features_items'] h2[class*='title']")
    protected WebElement allProductsHeader;

    @FindBy(css = "a[href*='product_details']")
    protected List<WebElement> product_details;

    @FindBy(id = "search_product")
    protected WebElement searchProductField;

    @FindBy(id = "submit_search")
    protected WebElement submitSearch;

    @FindBy(css = items+"p")
    protected List<WebElement> productInfo;

    @FindBy(css = items+"a[class*='add-to-cart']")
    protected List<WebElement> addToCart;

    @FindBy(css = "div[class='modal-content'] button")
    protected WebElement modalContentButton;

    @Override
    public boolean pageReady() {
        this.wait.until(ExpectedConditions.visibilityOf(this.allProductsHeader));
        return this.allProductsHeader.isDisplayed();
    }
}
