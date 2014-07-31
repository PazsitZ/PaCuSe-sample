package hu.pazsitz.seleniumtest.pages.hu.pazsitz;

import hu.pazsitz.pacuse.pages.AbstractPage;
import hu.pazsitz.pacuse.tests.annotations.DataTableAttributes;
import hu.pazsitz.seleniumtest.pages.hu.pazsitz.widgets.JQueryValidationCommentWidget;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class JQueryValidationInputPage extends AbstractPage {
	protected String pageUrl = "http://jqueryvalidation.org/files/demo/themerollered.html";
	
	private JQueryValidationCommentWidget jqValidationWidget;
	
	public JQueryValidationInputPage(WebDriver webDriver) {
		super(webDriver);
		jqValidationWidget = new JQueryValidationCommentWidget(webDriver);
	}

	@Override
	public String getUrl() {
		return pageUrl;
	}
	
	@DataTableAttributes(name="firstname")
	@FindBy(how=How.XPATH, using="//*[@id='signupForm']//input[@id='firstname']")
    private WebElement firstName;
	@DataTableAttributes(name="lastname")
	@FindBy(how=How.XPATH, using="//*[@id='signupForm']//input[@id='lastname']")
	private WebElement lastName;
	@DataTableAttributes(name="username")
	@FindBy(how=How.XPATH, using="//*[@id='signupForm']//input[@id='username']")
	private WebElement userName;
	
	@DataTableAttributes(name="password")
	@FindBy(how=How.XPATH, using="//*[@id='signupForm']//input[@id='password']")
	private WebElement password;
	@DataTableAttributes(name="password confirm")
	@FindBy(how=How.XPATH, using="//*[@id='signupForm']//input[@id='confirm_password']")
	private WebElement confirmPassword;
	
	@DataTableAttributes(name="email")
	@FindBy(how=How.XPATH, using="//*[@id='signupForm']//input[@id='email']")
	private WebElement email;
	
	@DataTableAttributes(name="privacy pol")
	@FindBy(how=How.XPATH, using="//*[@id='signupForm']//input[@id='agree']")
	private WebElement privacyPolicyCheckbox;
	
	@DataTableAttributes(name="newsletter", priority = 1)
	@FindBy(how=How.XPATH, using="//*[@id='signupForm']//input[@id='newsletter']")
	private WebElement newsletterCheckbox;
	@DataTableAttributes(name="marketflash")
	@FindBy(how=How.XPATH, using="//*[@id='signupForm']//input[@id='topic_marketflash']")
	private WebElement topicMarketflash;
	@DataTableAttributes(name="lattest fuzz")
	@FindBy(how=How.XPATH, using="//*[@id='signupForm']//input[@id='topic_fuzz']")
	private WebElement topicFuzz;
	@DataTableAttributes(name="mailingList")
	@FindBy(how=How.XPATH, using="//*[@id='signupForm']//input[@id='topic_digester']")
	private WebElement topicDigester;
	
	
	@FindBy(how=How.XPATH, using="//*[@id='signupForm']//button")
	private WebElement submitButton;

	public String getPageUrl() {
		return pageUrl;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPrivacyPolicyCheckbox() {
		return privacyPolicyCheckbox;
	}

	public WebElement getNewsletterCheckbox() {
		return newsletterCheckbox;
	}

	public WebElement getTopicMarketflash() {
		return topicMarketflash;
	}

	public WebElement getTopicFuzz() {
		return topicFuzz;
	}

	public WebElement getTopicDigester() {
		return topicDigester;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public JQueryValidationCommentWidget getJqueryValidationWidget() {
		return jqValidationWidget;
	}
	
	
	
}
