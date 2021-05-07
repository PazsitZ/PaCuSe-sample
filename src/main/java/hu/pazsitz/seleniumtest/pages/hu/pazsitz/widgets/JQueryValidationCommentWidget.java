package hu.pazsitz.seleniumtest.pages.hu.pazsitz.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import hu.pazsitz.pacuse.pages.AbstractWidget;

public class JQueryValidationCommentWidget extends AbstractWidget {

	@FindBy(how=How.XPATH, using="//*[@id='commentForm']")
	private WebElement container;


	public JQueryValidationCommentWidget(WebDriver webDriver) {
		super(webDriver);
	}

	@Override
	public WebElement getContainer() {
		return container;
	}

	@FindBy(how=How.XPATH, using="//*[@id='commentForm']//input[@id='cname']")
    private WebElement name;
	
	@FindBy(how=How.XPATH, using="//*[@id='commentForm']//input[@id='cemail']")
	private WebElement email;
	
	@FindBy(how=How.XPATH, using="//*[@id='commentForm']//input[@id='curl']")
	private WebElement formUrl;
	
	@FindBy(how=How.XPATH, using="//*[@id='commentForm']//textarea[@id='ccomment']")
	private WebElement comment;
	
	@FindBy(how=How.XPATH, using="//*[@id='commentForm']//button")
	private WebElement submitButton;

	public WebElement getName() {
		return name;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getFormUrl() {
		return formUrl;
	}

	public WebElement getComment() {
		return comment;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	
}
