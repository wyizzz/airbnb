import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
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
import genericUtil.GenericUtil as GenericUtil
import internal.GlobalVariable as GlobalVariable

KeywordLogger log = new KeywordLogger()
WebUI.click(findTestObject('homePage/inputButton_selectDates'))
WebUI.verifyElementPresent(findTestObject('homePage/assert/dateSelectionClicked'), 5)

TestObject select_startDateToday = CustomKeywords.'airbnbSelectors.SelectorBuilder.getStartDateSelector'()
CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(select_startDateToday, 5)

TestObject select_endDate = CustomKeywords.'airbnbSelectors.SelectorBuilder.getEndDateSelector'(durationDays)
while (!(CustomKeywords.'genericUtil.GenericUtil.isElementPresent'(select_endDate, 2))) {
    CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(findTestObject('homePage/button_nextMonth'), 5)
}
CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(select_endDate, 5)

TestObject assertionElementStartDate = CustomKeywords.'airbnbSelectors.SelectorBuilder.getAssertionElementStartDate'();
WebUI.verifyElementPresent(assertionElementStartDate, 5)

TestObject assertionElementEndDate = CustomKeywords.'airbnbSelectors.SelectorBuilder.getAssertionElementEndDate'(durationDays);
WebUI.verifyElementPresent(assertionElementStartDate, 5)
