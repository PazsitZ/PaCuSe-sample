package hu.pazsitz.seleniumtest.pages.com.expedia;

import hu.pazsitz.pacuse.pages.AbstractPage;
import hu.pazsitz.pacuse.tests.annotations.DataTableAttributes;
import hu.pazsitz.seleniumtest.pages.com.expedia.widgets.TripSummaryWidget;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage extends AbstractPage {
    private final String lxCheckoutPageUrl = "https://www.expedia.com/LXCheckout?";
    
    private final TripSummaryWidget tripSummary; 
    
    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
        tripSummary = registerWidget(TripSummaryWidget.class);
    }
    
    @Override
    public String getUrl() {
        return lxCheckoutPageUrl;
    }
    
    @DataTableAttributes(name="ContactName")
    @FindBy(how=How.XPATH, using="//input[@name='tripPreferencesRequest.lxTripPreferencesRequest.travelerName']")
    private WebElement contactNameInput;

    @DataTableAttributes(name="Email")
    @FindBy(how=How.XPATH, using="//input[@name='email']")
    private WebElement email;

    @FindBy(how=How.XPATH, using="id('country-code-trigger')")
    private WebElement phoneCountryVisibleSelector;
    @DataTableAttributes(name="Phone Country Code")
    @FindBy(how=How.XPATH, using="id('country-code')")
    private WebElement phoneCountrySelector;


    @DataTableAttributes(name="Phone")
    @FindBy(how=How.XPATH, using="id('phone-number')")
    private WebElement phoneNumberInput;


    @DataTableAttributes(name="CardNumber")
    @FindBy(how=How.XPATH, using="//input[@name='card_number']")
    private WebElement creditCardInput;


    @DataTableAttributes(name="CardType")
    @FindBy(how=How.XPATH, using="id('card-type-select')")
    private WebElement cardTypeSelector;


    @DataTableAttributes(name="ExpirationDateMonth")
    @FindBy(how=How.XPATH, using="//select[@name='expiration_month']")
    private WebElement expDateMonthSelector;


    @DataTableAttributes(name="ExpirationDateYear")
    @FindBy(how=How.XPATH, using="//select[@name='expiration_year']")
    private WebElement expDateYearSelector;
    
    
    @DataTableAttributes(name="CID")
    @FindBy(how=How.XPATH, using="//input[@name='new_card_security_code']")
    private WebElement cardIdNumberInput;

    @DataTableAttributes(name="CardHolderName")
    @FindBy(how=How.XPATH, using="//input[@name='cardholder_name']")
    private WebElement cardHolderNameInput;


    @DataTableAttributes(name="ZIP")
    @FindBy(how=How.XPATH, using="//input[@name='zipcode']")
    private WebElement zipCodeInput;


    @FindBy(how=How.XPATH, using="id('complete-booking')")
    private WebElement completeBookingSubmitButton;


    @FindBy(how=How.XPATH, using="id('rules-and-restrictions')/div[1]/a[1]")
    private WebElement rnRPageLink;


    @FindBy(how=How.XPATH, using="id('rules-and-restrictions')/div[1]/a[2]")
    private WebElement termsnCondPageLink;


    @FindBy(how=How.XPATH, using="id('rules-and-restrictions')/div[1]/a[3]")
    private WebElement privacyPolPageLink;


    @FindBy(how=How.XPATH, using="id('trip_summary_wrapper')/div[1]/div[3]/div[1]/span[2]/a[1]/span[1]")
    private WebElement tripSummaryPriceCollapseLink;
    
    @FindBy(how=How.XPATH, using="//fieldset[@class='login-module']")
    private WebElement loginModule;

    public String getLxCheckoutPageUrl() {
        return lxCheckoutPageUrl;
    }

    public WebElement getContactNameInput() {
        return contactNameInput;
    }
    
    public WebElement getEmail() {
		return email;
	}
    
    public WebElement getPhoneCountryVisibleSelector() {
        return phoneCountryVisibleSelector;
    }

    public WebElement getPhoneCountrySelector() {
        return phoneCountrySelector;
    }

    public WebElement getPhoneNumberInput() {
        return phoneNumberInput;
    }

    public WebElement getCreditCardInput() {
        return creditCardInput;
    }

    public WebElement getCardTypeSelector() {
        return cardTypeSelector;
    }

    public WebElement getExpDateMonthSelector() {
        return expDateMonthSelector;
    }

    public WebElement getExpDateYearSelector() {
        return expDateYearSelector;
    }
    
    public WebElement getCardIdNumberInput() {
        return cardIdNumberInput;
    }

    public WebElement getCardHolderNameInput() {
        return cardHolderNameInput;
    }

    public WebElement getZipCodeInput() {
        return zipCodeInput;
    }

    public WebElement getCompleteBookingSubmitButton() {
        return completeBookingSubmitButton;
    }

    public WebElement getRnRPageLink() {
        return rnRPageLink;
    }

    public WebElement getTermsnCondPageLink() {
        return termsnCondPageLink;
    }

    public WebElement getPrivacyPolPageLink() {
        return privacyPolPageLink;
    }

    public WebElement getTripSummaryPriceCollapseLink() {
        return tripSummaryPriceCollapseLink;
    }
    
    public WebElement getLoginModule() {
    	return loginModule;
    }

    public TripSummaryWidget getTripSummaryWidget() {
        return tripSummary;
    }
    
}
