package pageObjects.automationExercise.wiring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

import java.util.List;

public class ProductDetailsPageWiring extends AbstractPage {

    public ProductDetailsPageWiring(WebDriver driver) {
        super(driver);
    }

    private final String productInformation = "//div[@class='product-information']/";

    @FindBy(xpath= productInformation+"h2")
    protected WebElement productName;


    @FindBy(xpath= productInformation+"p[2]")
    protected WebElement availability;

    @FindBy(xpath= productInformation+"p[3]")
    protected WebElement condition;

    @FindBy(xpath= productInformation+"p[4]")
    protected WebElement brand;

    @Override
    public boolean pageReady() {
        this.wait.until(ExpectedConditions.visibilityOf(this.productName));
        return this.productName.isDisplayed();
    }
}
