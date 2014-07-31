package hu.pazsitz.seleniumtest.tests.cucumber.stepdefs;

import java.util.concurrent.TimeUnit;

import hu.pazsitz.pacuse.pageObjects.GeneralPageImplObject;
import hu.pazsitz.pacuse.tests.helpers.StepDefBase;
import hu.pazsitz.pacuse.tests.helpers.Waiters;
import hu.pazsitz.seleniumtest.pageObjects.com.expedia.CheckoutPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;

@StepDefAnnotation
public class LxCheckoutStepDefs {
    private final StepDefBase base;
    private final WebDriver driver;
    
    private CheckoutPageObject checkoutPage;

    public LxCheckoutStepDefs(StepDefBase base) {
        this.base = base;
        driver = this.base.getWebDriver();
        checkoutPage = new CheckoutPageObject(driver);
    }
    
    @Given("^the LX result page in Rome \"(.*?)\"$")
    public void the_LX_result_page_in_Rome(String arg1) throws Throwable {
    	driver.get("http://www.expedia.com/lx/?location=rome&startDate=2014-12-31&endDate=&regionId=179899");
    }

    @When("^I select the (\\d+) Activity$")
    public void i_select_the_Activity(int number) throws Throwable {
    	final WebElement activity = driver.findElement(By.xpath("//*[@id='activityResults']/article[" + number + "]/a"));
    	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Waiters.waitForCondition(new ExpectedCondition<Boolean>() {
    		@Override
    		public Boolean apply(WebDriver d) {
    			return activity.isDisplayed();
    		}
    	}, 10);
        activity.click();
    }

    @When("^on the Activity Details page I book the cheapest Price$")
    public void i_book_the_cheapest_Price() throws Throwable {
    	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    	Waiters.waitForCondition(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.findElements(By.id("activityModal")).isEmpty();
            }
        }, 10);
    			
    	driver.findElement(By.xpath("(//*[@id='offersContainer']//button[contains(concat(' ',@class,' '), ' addActivity ')])[1]")).click();
    }

    @Then("^I go to the Checkout Page$")
    public void i_go_to_the_Checkout_Page() throws Throwable {
    	if (!driver.getCurrentUrl().contains("/LXCheckout?"))
    		Waiters.waitForUrl("/LXCheckout?", 15);
    }
    
    @Then("^the user fills the necessary fields for Trip Preferences widget on Lx Checkout page$")
    public void the_user_fills_the_necessary_fields_for_Trip_Preferences_widget_on_Lx_Checkout_page(DataTable table) {
    	checkoutPage.fillOutContactDetails(table);
    }
    
    @Then("^the user fills the necessary fields for Payment widget on Lx Checkout page$")
    public void the_user_fills_the_necessary_fields_for_Payment_widget_on_Lx_Checkout_page(DataTable table) {
    	checkoutPage.fillOutCreditCardDetails(table);
    }
    
    @Then("^the user submits LX Booking$")
    public void the_user_submits_LX_Booking() {
    	checkoutPage.submitPage(false);
    }
    
    @Then("^It fails$")
    public void it_fails() throws Throwable {
    	Waiters.waitForMultipleUrlOnPayments(15, "LXCheckout");
    	Assert.assertEquals(driver.findElement(By.className("alert-message")).getText(),
    	"Sorry, there’s an issue with the payment information below.");
    	
    	// wait before close :)
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
	
	@When("^user clicks browser refresh button$")
    public void userClicksBrowserRefreshButton() {
    	base.getWebDriver().navigate().refresh();
    }

}
