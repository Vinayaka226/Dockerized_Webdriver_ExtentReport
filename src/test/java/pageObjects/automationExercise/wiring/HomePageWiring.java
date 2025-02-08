package pageObjects.automationExercise.wiring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPage;

import java.util.List;

public class HomePageWiring extends AbstractPage {

    public HomePageWiring(WebDriver driver){
        super(driver);
    }

    private final String leftSideBar = "div[class='left-sidebar']";
    private final String leftSideBarCategory = " h2[css='";
    private final String leftSideBarBrand = " h2[xpath='";
    private final String leftSideBarClose = "']";

    @FindBy(css = "div[class*='shop-menu'] ul li a")
    protected List<WebElement> topNavMenuLinks;

    @FindBy(css = "#accordian div h4")
    protected List<WebElement> categories;

    @FindBy(css = leftSideBar+leftSideBarCategory+"1"+leftSideBarClose)
    protected WebElement category;

    @FindBy(css = leftSideBar+leftSideBarBrand+"1"+leftSideBarClose)
    protected WebElement brand;

    @FindBy(css = ".single-widget h2")
    protected WebElement subscription;

    @FindBy(id = "scrollUp")
    protected WebElement scrollUp;

    @Override
    public boolean pageReady() {
        this.wait.until(ExpectedConditions.visibilityOfAllElements(this.topNavMenuLinks));

        return this.topNavMenuLinks.getFirst().isDisplayed();
    }
}
