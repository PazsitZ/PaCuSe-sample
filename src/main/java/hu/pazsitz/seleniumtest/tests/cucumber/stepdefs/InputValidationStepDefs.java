package hu.pazsitz.seleniumtest.tests.cucumber.stepdefs;

import static org.testng.Assert.assertEquals;
import hu.pazsitz.pacuse.tests.helpers.FormHelper;
import hu.pazsitz.pacuse.tests.helpers.StepDefBase;
import hu.pazsitz.seleniumtest.pageObjects.hu.pazsitz.JQueryValidationInputPageObject;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;

/**
 * NameCardStepDef.java
 *
 * @author Zoltan Pazsit <pazsitz@pazsitz.hu>
 * @copyright Copyright (c) 2014, Zoltan Pazsit
 */
@StepDefAnnotation
public class InputValidationStepDefs {

	private final StepDefBase base;
    private final JQueryValidationInputPageObject inputPageObject;

    public InputValidationStepDefs(StepDefBase stepDefBase) {
        this.base = stepDefBase;
        inputPageObject = new JQueryValidationInputPageObject(base.getWebDriver());
    }
    
    @Given("^the jQuery Validation Page$")
    public void theJQueryValidationPage() {
    	assertEquals("jQuery validation plug-in - ThemeRolldered demo", inputPageObject.getPage().getTitle());
    }
    
    @Given("^preFill the newsletter checkbox with (.+) value$")
    public void preFillTheNewsletterCheckboxWithValue(String value) {
    	WebElement element = inputPageObject.getPage().getNewsletterCheckbox();
    	FormHelper.checkboxTicker(element, value);
    }
    
    @Given("^validate the Validation Form page content:$")
//    public void thenValidateTheAboutPageContent(List<LinkedHashMap<String, String>> table) {
//    	inputPageObject.validateForm(Collections.singletonList((Map<String, String>)table.get(0)));
    	public void thenValidateTheAboutPageContent(List<Map<String, String>> table) {
    	inputPageObject.validateForm(table);
    }
    
    @When("^fill out the Validation Form:$")
    public void fillOutTheValidationForm(List<Map<String, String>> table){
    	inputPageObject.fillOutForm(Collections.singletonList((Map<String, String>)table.get(0)));
    }
    
    @When("^fix the email to \"(.*?)\"$")
    public void fixTheEmailTo(String email) {
    	WebElement emailField = inputPageObject.getPage().getEmail();
    	emailField.clear();
    	emailField.sendKeys(email);
    }
}
