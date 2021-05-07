package hu.pazsitz.seleniumtest.pages.com.expedia.widgets;

import hu.pazsitz.pacuse.pages.AbstractWidget;
import hu.pazsitz.pacuse.tests.annotations.DataTableAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class TripSummaryWidget extends AbstractWidget {

    @FindBy(how=How.XPATH, using="id(\"trip_summary_wrapper\")")
    private WebElement container;

    public TripSummaryWidget(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public WebElement getContainer() {
        return container;
    }

    @DataTableAttributes(name = "DX activity name 0")
    @FindBy(how=How.XPATH, using="id(\"trip_summary_wrapper\")//div[@class=\"product-title\"]")
    private WebElement productTitle;
    
    @DataTableAttributes(name = "DX activity item title 0")
    @FindBy(how=How.XPATH, using="id(\"trip_summary_wrapper\")//div[@class=\"product-sub-title\"]")
    private WebElement productSubTitle;
    
    @FindBy(how=How.XPATH, using="id(\"trip_summary_wrapper\")//div[@class=\"product-attributes\"]")
    private WebElement attributes;

    @FindBy(how=How.XPATH, using="//span[class~=\"date\"]")
    private WebElement date;
    
    @FindBy(how=How.XPATH, using="//div[@class=\"price-line\"]//a")
    private WebElement priceDetailsButton;
    
    @FindBy(how=How.XPATH, using="//*[@data-price-update=\"summaryTotalPrice\"]")
    private WebElement totalPrice;

    @DataTableAttributes(name = "DX activity price 0")
    @FindBy(how=How.XPATH, using="//*[@data-price-update=\"summaryTicketPrice.0\"]")
    private WebElement ticketType1Price;


    public WebElement getProductTitle() {
        return productTitle;
    }


    public WebElement getProductSubTitle() {
        return productSubTitle;
    }


    public WebElement getAttributes() {
        return attributes;
    }


    public WebElement getDate() {
        return date;
    }


    public WebElement getTotalPrice() {
        return totalPrice;
    }


    public WebElement getTicketTypePrice() {
        return ticketType1Price;
    }


    public WebElement getPriceDetailsButton() {
        return priceDetailsButton;
    }

    
    
}
