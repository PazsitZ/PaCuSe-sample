package hu.pazsitz.seleniumtest.pageObjects.hu.pazsitz;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import hu.pazsitz.pacuse.pageObjects.AbstractPageObject;
import hu.pazsitz.pacuse.tests.cucumber.featuretables.ComparatorDataTable;
import hu.pazsitz.pacuse.tests.cucumber.featuretables.FieldActionResult;
import hu.pazsitz.pacuse.tests.cucumber.featuretables.PopulatorDataTable;
import hu.pazsitz.seleniumtest.pageObjects.hu.pazsitz.widgets.JQuerValidationCommentWidgetObject;
import hu.pazsitz.seleniumtest.pages.hu.pazsitz.JQueryValidationInputPage;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class JQueryValidationInputPageObject extends AbstractPageObject<JQueryValidationInputPage> {

	private JQuerValidationCommentWidgetObject jqValidationWidgetObject;
	
	public JQueryValidationInputPageObject(WebDriver webDriver) {
		super(JQueryValidationInputPage.class, webDriver, true);
		jqValidationWidgetObject = new JQuerValidationCommentWidgetObject(page.getJqueryValidationWidget(), webDriver);
	}

	public JQuerValidationCommentWidgetObject getJqueryValidationWidgetObject() {
		return jqValidationWidgetObject;
	}
	
	
	public void fillOutForm(List<Map<String, String>> table) {
		PopulatorDataTable populatorTable = new PopulatorDataTable(table);
		FieldActionResult result = populatorTable.populateToPageModel(page);
		assertTrue(result.success(),  result.getNonSucceedFields().toString());
		assertFalse(result.fullSuccess(), result.getNonSucceedFields().toString());
		assertEquals(result.getSuccessFields().size(), 11);
	}
	
	public void validateForm(List<Map<String, String>> table) {
		ComparatorDataTable comparatorTable = new ComparatorDataTable(table);
		FieldActionResult result = comparatorTable.compareToPageModel(page);
		assertTrue(result.success(), result.getNonSucceedFields().toString());
		assertTrue(result.fullSuccess(), result.getNonSucceedFields().toString());
		assertEquals(result.getSuccessFields().size(), result.getFieldNumber());
	}
	

	
}
