package airbnbSelectors

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import com.kms.katalon.core.testobject.ConditionType
import java.text.DateFormat;
import java.text.SimpleDateFormat
import java.util.Calendar;

import internal.GlobalVariable

public class SelectorBuilder {

	@Keyword
	def TestObject getGuestCountAssertionSelector(int adults, int children, int infants) {
		int guests = adults+children;
		String xpathFormat = "//span[@aria-label=\""+guests+" guests, "+infants+" infants\"]";
		TestObject selectorObject = new TestObject()
		selectorObject.addProperty("xpath", ConditionType.EQUALS, xpathFormat)
		return selectorObject
		// //span[@aria-label="5 guests, 3 infants"]
	}

	@Keyword
	def TestObject getStartDateSelector(){
		Date d = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

		Calendar c = Calendar.getInstance();
		//get current TimeZone using
		TimeZone tz = c.getTimeZone();
		formatDate.setTimeZone(tz)
		String dateToday = formatDate.format(d);

		// //div[data-testid="datepicker-day-2020-07-25"]
		String dateSelectorFormat="div[data-testid=\"datepicker-day-"+dateToday+"\"]"

		TestObject selectorObject = new TestObject()
		selectorObject.addProperty("css", ConditionType.EQUALS, dateSelectorFormat)
		return selectorObject;
	}

	@Keyword
	def TestObject getEndDateSelector(int durationDays){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, durationDays);
		String formatEndDate = sdf.format(c.getTime());

		// div[data-testid="datepicker-day-2020-07-25"]
		String dateSelectorFormat="div[data-testid=\"datepicker-day-"+formatEndDate+"\"]";

		TestObject selectorObject = new TestObject()
		selectorObject.addProperty("css", ConditionType.EQUALS, dateSelectorFormat)
		return selectorObject;
	}

	@Keyword
	def TestObject getAssertionElementStartDate(){
		Date d = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("EEEE, MMMM dd, yyyy");

		Calendar c = Calendar.getInstance();
		//get current TimeZone using
		TimeZone tz = c.getTimeZone();
		formatDate.setTimeZone(tz)
		String dateFormat = formatDate.format(d);

		//td[aria-label="Selected start date. Saturday, July 25, 2020"]
		String assertionElementFormat="td[aria-label=\"Selected start date. "+dateFormat+"\"]";

		TestObject assertionObject = new TestObject()
		assertionObject.addProperty("css", ConditionType.EQUALS, assertionElementFormat)
		return assertionObject;
	}

	@Keyword
	def TestObject getAssertionElementEndDate(int durationDays){
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, durationDays);
		String formatEndDate = sdf.format(c.getTime());

		//div[data-testid="datepicker-day-2020-07-25"]
		String assertionElementFormat="td[aria-label=\"Selected end date. "+formatEndDate+"\"]";

		TestObject assertionObject = new TestObject()
		assertionObject.addProperty("css", ConditionType.EQUALS, assertionElementFormat)
		return assertionObject;
	}
}
