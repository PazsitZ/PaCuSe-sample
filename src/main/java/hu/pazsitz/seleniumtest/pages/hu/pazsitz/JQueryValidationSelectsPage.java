package hu.pazsitz.seleniumtest.pages.hu.pazsitz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import hu.pazsitz.pacuse.pages.AbstractPage;
import hu.pazsitz.pacuse.tests.annotations.DataTableAttributes;

public class JQueryValidationSelectsPage extends AbstractPage {
	protected String pageUrl = "http://jqueryvalidation.org/files/demo/radio-checkbox-select-demo.html";

	public JQueryValidationSelectsPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Override
	public String getUrl() {
		return pageUrl;
	}
	
	@DataTableAttributes(name="jungle")
	@FindBy(how=How.XPATH, using="//*[@id='selecttest']//select[@id='jungle']")
    private WebElement jungleSelect;
	@DataTableAttributes(name="fruits")
	@FindBy(how=How.XPATH, using="//*[@id='selecttest']//select[@id='fruit']")
	private WebElement friutSelect;
	
	@DataTableAttributes(name="vegetable")
	@FindBy(how=How.XPATH, using="//*[@id='selecttest']//select[@id='vegetables']")
	private WebElement vegetablesSelect;
	@DataTableAttributes(name="cars")
	@FindBy(how=How.XPATH, using="//*[@id='selecttest']//select[@id='cars']")
	private WebElement carsSelect;
	
	@FindBy(how=How.XPATH, using="//*[@id='selecttest']//input[@type='submit']")
	private WebElement submitButton;

	public WebElement getJungleSelect() {
		return jungleSelect;
	}

	public WebElement getFriutSelect() {
		return friutSelect;
	}

	public WebElement getVegetablesSelect() {
		return vegetablesSelect;
	}

	public WebElement getCarsSelect() {
		return carsSelect;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	
}
