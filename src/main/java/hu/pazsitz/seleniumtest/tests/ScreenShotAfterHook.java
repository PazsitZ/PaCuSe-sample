package hu.pazsitz.seleniumtest.tests;

import hu.pazsitz.pacuse.tests.helpers.StepDefBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.runtime.java.StepDefAnnotation;

@StepDefAnnotation
public class ScreenShotAfterHook {
	private StepDefBase base;
	
	public ScreenShotAfterHook(StepDefBase base) {
		this.base = base;
	}
	
	@After
    public void after(Scenario scenario) {
    	base.getWebDriver().embedScreenshot(scenario);
    }
}
