package pageObjects.automationExercise.wiring;

import io.opentelemetry.sdk.metrics.internal.view.ExplicitBucketHistogramAggregation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

import java.util.List;

public class CartPageWiring extends AbstractPage {

    public CartPageWiring(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='breadcrumbs'] //ol //li[@class='active']")
    protected WebElement cartInfo;

    @FindBy(css = "#cart_info_table tbody tr")
    protected List<WebElement> cartItems;

    @Override
    public boolean pageReady() {
        this.wait.until(ExpectedConditions.visibilityOf(this.cartInfo));
        return this.cartInfo.isDisplayed();
    }
}
