package hu.pazsitz.seleniumtest.pageObjects.com.expedia.widgets;

import hu.pazsitz.pacuse.pageObjects.AbstractWidgetObject;
import hu.pazsitz.pacuse.tests.helpers.Waiters;
import hu.pazsitz.seleniumtest.pages.com.expedia.widgets.TripSummaryWidget;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;

public class TripSummaryWidgetObject extends AbstractWidgetObject<TripSummaryWidget> {

    public TripSummaryWidgetObject(TripSummaryWidget widget, WebDriver webDriver) {
        super(widget, webDriver);
    }
    
    public void openPriceDetails() {
        if (!widget.getTicketTypePrice().isDisplayed()) {
            widget.getPriceDetailsButton().click();
        }
        Waiters.waitForIdDisplayed("standaloneToggle1", 5);
    }
    
    public void closePriceDetails() {
        if (widget.getTicketTypePrice().isDisplayed()) {
            widget.getPriceDetailsButton().click();
        }
    }

	public void validateSummaryModuleContent() {
		new PendingException();
	}

}
