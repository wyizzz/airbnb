import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

KeywordLogger log = new KeywordLogger()

CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(findTestObject('searchResultsPage/button_guests'), 5)


int adultCount = Integer.parseInt(adults);
int childrenCount = Integer.parseInt(children);
int infantCount = Integer.parseInt(infants);

for (int i = 0; i < adultCount; i++) {
//	log.logWarning(i+" and adult: "+adults)
    CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(findTestObject('searchResultsPage/button_increaseAdults'), 5)
}

for (int i = 0; i < childrenCount; i++) {
    CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(findTestObject('searchResultsPage/button_increaseChildren'), 5)
}

for (int i = 0; i < infantCount; i++) {
    CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(findTestObject('searchResultsPage/button_increaseInfants'), 5)
}

CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(findTestObject('searchResultsPage/button_saveGuestFilters'), 5);

TestObject guestAssertionElement = CustomKeywords.'airbnbSelectors.SelectorBuilder.getGuestCountAssertionSelector'(adultCount, childrenCount, infantCount)

WebUI.verifyElementPresent(guestAssertionElement, 5)

