package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Utility to get the needed drivers
 */
public class WebDriverFactory {

    private static ChromeOptions chromeOptions =  new ChromeOptions();

    private static final Supplier<WebDriver> chromeSupplier = () -> {   chromeOptions.addArguments("--start-maximized");
                                                                        WebDriver driver = new ChromeDriver(chromeOptions);
                                                                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                                                                        return driver;
                                                                    };
    private static final Supplier<WebDriver> firefoxSupplier = () ->{
                                                                        WebDriver driver = new FirefoxDriver();
                                                                        driver.manage().window().maximize();
                                                                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                                                                        return driver;
                                                                    };
    private static final Supplier<WebDriver> edgeSupplier = EdgeDriver::new;

    private static final Map<String,Supplier<WebDriver>> DRIVER_SUPPLIER = Map.of(
            "chrome",chromeSupplier,
            "firefox",firefoxSupplier,
            "edge",edgeSupplier
    );

    /**
     * Method to get the driver from DRIVER_SUPPLIER
     * @param browserName
     * @return WebDriver
     */
    public static WebDriver getDriver(String browserName){
        return DRIVER_SUPPLIER.get(browserName).get();
    }
}
