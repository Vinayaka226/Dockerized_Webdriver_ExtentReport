package pageObjects.automationExercise.agent;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageObjects.automationExercise.wiring.TestCasePageWiring;

import static util.Commons.logsReporter;

public class TestCasePageAgent extends TestCasePageWiring {

    private static final Logger log = LoggerFactory.getLogger(TestCasePageAgent.class);
    public TestCasePageAgent(WebDriver driver) {
        super(driver);
        pageReady();
    }

    /**
     * Asserting title equals: TEST CASES
     */
    public void assertTestCaseTitle(){
        String pageTitle = "TEST CASES";
        logsReporter("Asserting title equals: "+pageTitle, log);
        Assert.assertTrue(this.title.getText().contains(pageTitle));
    }
}
