package hu.pazsitz.seleniumtest.pages.hu.pazsitz;

import hu.pazsitz.pacuse.pages.AbstractPage;
import hu.pazsitz.pacuse.tests.annotations.DTAInputHandling;
import hu.pazsitz.pacuse.tests.annotations.DataTableAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * NameCardPage.java
 *
 * @author Zoltan Pazsit <pazsitz@pazsitz.hu>
 * @copyright Copyright (c) 2014, Zoltan Pazsit
 */
public class NameCardPage extends AbstractPage {
    private final String pageUrl = "http://pazsitz.hu";

    public NameCardPage(WebDriver webDriver) {
        super(webDriver);
    }

	@Override
    public String getUrl() {
        return pageUrl;
    }
	
    @DataTableAttributes(name="name")
    @FindBy(how=How.XPATH, using="//div[contains(concat(' ',@class,' '), ' about ')]/div/span/h2")
    private WebElement name;

    @DataTableAttributes(name="profession")
    @FindBy(how=How.XPATH, using="//div[contains(concat(' ',@class,' '), ' about ')]//span[@class='profession']")
    private WebElement profession;


    @FindBy(how=How.XPATH, using="//div[contains(concat(' ',@class,' '), ' about ')]")
    private WebElement aboutCardPanel;

    @FindBy(how=How.XPATH, using="//div[contains(concat(' ',@class,' '), ' contact ')]")
    private WebElement contactCardPanel;

    @DataTableAttributes(name="email1", priority = 1)
    @FindBy(how=How.XPATH, using="//span[contains(concat(' ',@class,' '), ' email-contact ')]/a")
    private WebElement contactEmail1;

    @DataTableAttributes(name="email2", priority = 1)
    @FindBy(how=How.XPATH, using="//span[contains(concat(' ',@class,' '), ' email-pazsitz ')]/a")
    private WebElement contactEmail2;

    @DataTableAttributes(name={"webPage", "web Page Url"}, priority = 2, 
		inputHandling = DTAInputHandling.CUSTOM_ATTRIBUTE, attribute = "href")
    @FindBy(how=How.XPATH, using="//a[contains(concat(' ',@class,' '), ' link-pazsitz ')]")
    private WebElement webPageUrlLink;

    @DataTableAttributes(name="Facebook", priority = 2)
    @FindBy(how=How.XPATH, using="//a[contains(concat(' ',@class,' '), ' link-facebook ')]")
    private WebElement fBUrlLink;

    @DataTableAttributes(name="LinkedIn", priority = 2)
    @FindBy(how=How.XPATH, using="//a[contains(concat(' ',@class,' '), ' link-linkedin ')]")
    private WebElement linkedInUrlLink;
    
    @DataTableAttributes(name="Github", priority = 2)
    @FindBy(how=How.XPATH, using="//a[contains(concat(' ',@class,' '), ' link-github-pazsitz ')]")
    private WebElement githubUrlLink;

	public WebElement getAboutCardPanel() {
		return aboutCardPanel;
	}

	public WebElement getContactCardPanel() {
		return contactCardPanel;
	}

	public WebElement getContactEmail1() {
		return contactEmail1;
	}

	public WebElement getContactEmail2() {
		return contactEmail2;
	}

	public WebElement getWebPageUrlLink() {
		return webPageUrlLink;
	}

	public WebElement getFBUrlLink() {
		return fBUrlLink;
	}

	public WebElement getLinkedInUrlLink() {
		return linkedInUrlLink;
	}
	
	public WebElement getGithubUrlLink() {
		return githubUrlLink;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getProfession() {
		return profession;
	}

	public WebElement getfBUrlLink() {
		return fBUrlLink;
	}
	


}
