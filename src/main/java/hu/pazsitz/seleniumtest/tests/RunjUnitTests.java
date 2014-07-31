package hu.pazsitz.seleniumtest.tests;

import hu.pazsitz.pacuse.tests.ReportGenerator;
import hu.pazsitz.pacuse.tests.helpers.StepDefBase;
import hu.pazsitz.pacuse.tests.helpers.WebDriverFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * RunjUnitTests.java
 *
 * @author Zoltan Pazsit <pazsitz@pazsitz.hu>
 * @copyright Copyright (c) 2014, Zoltan Pazsit
 */
@RunWith(Cucumber.class) // requires jUnit-4.11.jar + hamcrest-all-1.3.jar
@CucumberOptions(
        format = {"pretty", "html:reports/cucumber-html-report", "json:reports/cucumber-report.json"},
        features="src/main/java/hu/pazsitz/seleniumtest/tests/cucumber/features"
//        ,tags = { "@LXLive" } //what tags to include(@)/exclude(@~)
    )
public class RunjUnitTests {
    
    @BeforeClass
    public static void init() {
        System.setProperty("cucumber.report.embed_screenshot", Boolean.toString(true));
        System.setProperty("PaCuSe.browser", WebDriverFactory.BrowserName.CHROME.name());
        System.setProperty("PaCuSe.WebDriver.screenshot.path", "./reports/");
        System.setProperty("PaCuSe.ReportGenerator.outputReport.path", "./reports/");
        System.setProperty("PaCuSe.ReportGenerator.jsonReport.path", "./reports/");
    }

    @AfterClass
    public static void TestSuiteTearDown() {
    	StepDefBase.getInstance().tearDown();
        ReportGenerator.main(null);
    }
}