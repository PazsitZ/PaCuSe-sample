package hu.pazsitz.seleniumtest.tests;

import hu.pazsitz.pacuse.tests.AbstractTestNGCucumberWithReporterTests;
import hu.pazsitz.pacuse.tests.ReportGenerator;
import hu.pazsitz.pacuse.tests.helpers.StepDefBase;
import hu.pazsitz.pacuse.tests.helpers.WebDriverFactory;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

/**
 * RunTestNgTests.java
 *
 * @author Zoltan Pazsit <pazsitz@pazsitz.hu>
 * @copyright Copyright (c) 2014, Zoltan Pazsit
 */
@Test(groups={"cucumber"})
@CucumberOptions(
    format = {"pretty", "html:reports/cucumber-html-report", "json:reports/cucumber-report.json"},
    features="src/main/java/hu/pazsitz/seleniumtest/tests/cucumber/features",
//    tags = { "@select" }, //what tags to include(@)/exclude(@~)
    snippets = SnippetType.CAMELCASE
)
// Default TestNG Runner, runs all of the features are available
public class RunTestNgTests extends AbstractTestNGCucumberWithReporterTests {
    /**
     * Right now the Cucumber ReportGenerator doesn't support embed image only the HtmlReportGenerator
     */
    
    @BeforeClass
    public void init() {
    	setFilePathOfStepDefinitions("src/main/java/hu/pazsitz/seleniumtest/tests/cucumber/stepdefs/");
        System.setProperty("cucumber.report.embed_screenshot", Boolean.toString(true));
        System.setProperty("PaCuSe.browser", WebDriverFactory.BrowserName.FIREFOX.name());
        System.setProperty("PaCuSe.WebDriver.screenshot.path", "reports/");
        System.setProperty("PaCuSe.ReportGenerator.outputReport.path", "reports/");
        System.setProperty("PaCuSe.ReportGenerator.jsonReport.path", "reports/");
    }
    
    @AfterClass
    public void TestSuiteTearDown() {
    	StepDefBase.getInstance().tearDown();
        ReportGenerator.main(null);
    }
}