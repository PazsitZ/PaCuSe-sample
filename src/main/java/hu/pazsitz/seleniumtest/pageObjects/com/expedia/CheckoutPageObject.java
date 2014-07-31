package hu.pazsitz.seleniumtest.pageObjects.com.expedia;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import hu.pazsitz.pacuse.pageObjects.AbstractPageObject;
import hu.pazsitz.pacuse.pageObjects.GeneralPageImplObject;
import hu.pazsitz.pacuse.pages.AbstractPage;
import hu.pazsitz.pacuse.tests.cucumber.featuretables.FieldActionResult;
import hu.pazsitz.pacuse.tests.cucumber.featuretables.PopulatorDataTable;
import hu.pazsitz.pacuse.tests.helpers.Waiters;
import hu.pazsitz.seleniumtest.pageObjects.com.expedia.widgets.TripSummaryWidgetObject;
import hu.pazsitz.seleniumtest.pages.com.expedia.CheckoutPage;
import hu.pazsitz.seleniumtest.pages.com.expedia.widgets.TripSummaryWidget;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.PendingException;

public class CheckoutPageObject extends AbstractPageObject<CheckoutPage>{
	private TripSummaryWidgetObject tripSummaryWidgetObject;
	
    private static final String ZIP_CODE = "98004";
    private static final String CARDHOLDER_NAME = "Test User";
    private static final String CC_ID_NUMBER = "123";
    private static final String CC_EXP_MONTH = "7";
    private static final String CC_TYPE = "Visa";
    private static final String CC_NUMBER = "1231111111111789";
    private static final String PHONE_NUMBER = "555-12345";
    private static final String USA = "usa";
    private static final String TEST_USER_NAME = "Test User Name";

    public CheckoutPageObject(WebDriver webDriver) {
        super(CheckoutPage.class, webDriver);
        tripSummaryWidgetObject = registerWidgetObject(TripSummaryWidgetObject.class, page.getTripSummaryWidget());
    }
    
    public TripSummaryWidget getTripSummaryWidget() {
        return page.getTripSummaryWidget();
    }
    
    public TripSummaryWidgetObject getTripSummaryWidgetObject() {
    	return tripSummaryWidgetObject;
    }
    
    public void fillOutContactDetails() {
        fillOutContactDetails(TEST_USER_NAME, USA, PHONE_NUMBER);
    }
    
    public void fillOutContactDetails(DataTable dataTable) {
    	List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
    	PopulatorDataTable populatorTable = new PopulatorDataTable(table);
    	FieldActionResult result = populatorTable.populateToPageModel(page);
    	if (isLoggedInUser()) {
    		assertEquals(result.getFailedFields().size(), 1);
    		assertTrue(result.getFailedFields().containsKey("Email"));
    	} else {
    		assertTrue(result.fullSuccess(), result.getNonSucceedFields().toString());
    	}
    }
    
    
    public void fillOutContactDetails(String contactName, String phoneCountryCode, String phoneNumber) {
        page.getContactNameInput().clear();
        page.getContactNameInput().sendKeys(contactName);
        selectPhoneCountry(phoneCountryCode);
        page.getPhoneNumberInput().sendKeys(phoneNumber);
    }

    private void selectPhoneCountry(String phoneCountryCode) {
        page.getPhoneCountryVisibleSelector().click();
        
        phoneCountryCode = phoneCountryCode.trim().toLowerCase();
        
        WebElement phonecountryElement = webDriver.findElement(new ByChained(
            By.id("ccodesTT"), 
            By.className("countries-flags"), 
            By.cssSelector("a[data-country-iso='" + phoneCountryCode +"']")
        ));
        
        phonecountryElement.click();
    }
    
    public void fillOutCreditCardDetails(DataTable dataTable) {
    	List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
    	PopulatorDataTable populatorTable = new PopulatorDataTable(table);
    	FieldActionResult result = populatorTable.populateToPageModel(page);
    	assertTrue(result.fullSuccess(), result.getNonSucceedFields().toString());
    }
    
    public void fillOutCreditCardDetails() {
        fillOutCreditCardDetails(CC_NUMBER, CC_TYPE, CC_EXP_MONTH, getNextYear(), CC_ID_NUMBER, CARDHOLDER_NAME, ZIP_CODE);
    }
    
    /**
     * Retruns with abstact because the result can be the follows: (checkoutpage - CheckoutPageObject, errorPage - PageImplObject, or confirmation - PageImplObject)
     * 
     * @return
     */
    public AbstractPageObject<?> submitPage(boolean autoFill) {
        if (autoFill) {
            fillOutContactDetails();
            fillOutCreditCardDetails();
        }
        
        page.getCompleteBookingSubmitButton().click();
        try {
        	Waiters.waitForMultipleUrlOnPayments(10, "LXCheckout", "LXCheckoutError", "LXConfirmation", "/trips/");
        } catch (TimeoutException e) {
        	if (!isClientSideErrorAppeared()) {
        		throw e;
        	}
        }
        
        AbstractPageObject<? extends AbstractPage> newPageObject = new GeneralPageImplObject(webDriver);
        
        Waiters.waitForDocumentReady(5);
        
        String pageId = webDriver.findElement(By.tagName("body")).getAttribute("data-pageid");
        if ("page.LX.Checkout.Payment".equals(pageId)) {
            newPageObject = new CheckoutPageObject(webDriver);
        }
        
        return newPageObject;
        
    }

	private boolean isClientSideErrorAppeared() {
		try {
			return webDriver.findElement(By.cssSelector(".validation-msg.error")).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
    
    /**
     * If you're sure the page will bring back to PaymentsPage
     * 
     * @return
     */
    public CheckoutPageObject submitPageWithRedirect() {
        page.getCompleteBookingSubmitButton().click();
        
        Waiters.waitForIdDisplayed("page-level-error", 10);
        
        return new CheckoutPageObject(webDriver);
    }
    
    /**
     * If you're sure the page will bring back to PaymentsPage
     * 
     * @return
     */
    public CheckoutPageObject submitPageWithClientSideError() {
    	page.getCompleteBookingSubmitButton().click();
    	
    	Waiters.waitForClassDisplayed("error-text", 10);
    	
    	return new CheckoutPageObject(webDriver);
    }

    private String getNextYear() {
        Calendar prevYear = Calendar.getInstance();
        prevYear.add(Calendar.YEAR, +1);
        return String.valueOf(prevYear.get(Calendar.YEAR));
    }
    
    public void fillOutCreditCardDetails(String ccNumber, String ccType, String ccExpDateMonth, String ccExpDateYear, String ccIdNumber, String ccCardholderName, String ccZipCode) {
        page.getCreditCardInput().sendKeys(ccNumber);
        Select dropdownCcType = new Select(page.getCardTypeSelector());
        dropdownCcType.selectByValue(ccType);
        page.getExpDateMonthSelector().sendKeys(ccExpDateMonth);
        Select dropdownExpMonth = new Select(page.getExpDateMonthSelector());
        dropdownExpMonth.selectByValue(ccExpDateMonth);
        page.getExpDateYearSelector().sendKeys(ccExpDateYear);
        Select dropdownExpYear = new Select(page.getExpDateYearSelector());
        dropdownExpYear.selectByValue(ccExpDateYear);
        page.getCardIdNumberInput().sendKeys(ccIdNumber);
        page.getCardHolderNameInput().sendKeys(ccCardholderName);
        page.getZipCodeInput().sendKeys(ccZipCode);
    }

    public boolean isLoggedInUser() {
    	return !page.getLoginModule().isDisplayed();
    }
    
    public void loginWithCredentials(String email, String pass) {
    	new PendingException();
    }
}
