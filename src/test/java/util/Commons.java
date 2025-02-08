package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import util.Listeners.ExtentListeners;

public class Commons {

    /**
     * Common logging method
     * @param message
     * @param log
     */
    public static void logsReporter(String message, Logger log){
        log.info(message);
        ExtentListeners.testReport.get().info(message);
    }
    /**
     * Common Utility to select from dropdown based on visible text
     * @param element
     * @param text
     */
    public static void dropdownSelectVisibleText(WebElement element, String text){
        Select dropdown =  new Select(element);
        dropdown.selectByVisibleText(text);
    }

    public static void hoverOverElementAndClick(Actions action, WebElement element){
        action.moveToElement(element)
                .click()
                .build()
                .perform();
    }
}
