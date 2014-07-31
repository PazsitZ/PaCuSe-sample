package hu.pazsitz.seleniumtest.tests.cucumber.stepdefs;

import static org.testng.Assert.assertEquals;
import java.util.List;
import java.util.Map;

import hu.pazsitz.pacuse.tests.helpers.StepDefBase;
import hu.pazsitz.seleniumtest.pageObjects.hu.pazsitz.JQueryValidationSelectsPageObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;

@StepDefAnnotation
public class SelectValidationStepDefs {

	    private final StepDefBase base;
	    private final JQueryValidationSelectsPageObject selectPageObject;

	    public SelectValidationStepDefs(StepDefBase stepDefBase) {
	        this.base = stepDefBase;
	        selectPageObject = new JQueryValidationSelectsPageObject(base.getWebDriver());
	    }
	   
	    @Given("^the jQuery Select Validation Page$")
	    public void theJQuerySelectValidationPage() throws Throwable {
	        assertEquals("Test for jQuery validate() plugin", selectPageObject.getPage().getTitle());
	    }

	    @When("^fill out the Select Validation Form:$")
	    public void fillOutTheSelectValidationForm(List<Map<String, String>> table) throws Throwable {
	        selectPageObject.fillOutForm(table);
	    }

	    @Then("^validate the Select Validation Form page content:$")
	    public void validateTheSelectValidationFormPageContent(List<Map<String, String>> table)
	            throws Throwable {
	        selectPageObject.validateForm(table);
	    }
}
