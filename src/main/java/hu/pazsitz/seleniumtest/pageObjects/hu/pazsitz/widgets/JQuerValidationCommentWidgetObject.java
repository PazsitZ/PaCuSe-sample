package hu.pazsitz.seleniumtest.pageObjects.hu.pazsitz.widgets;

import org.openqa.selenium.WebDriver;

import hu.pazsitz.pacuse.pageObjects.AbstractWidgetObject;
import hu.pazsitz.seleniumtest.pages.hu.pazsitz.widgets.JQueryValidationCommentWidget;

public class JQuerValidationCommentWidgetObject extends AbstractWidgetObject<JQueryValidationCommentWidget> {

	public JQuerValidationCommentWidgetObject(JQueryValidationCommentWidget widget, WebDriver webDriver) {
		super(widget, webDriver);
	}

}
