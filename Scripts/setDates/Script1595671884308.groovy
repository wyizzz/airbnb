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

WebUI.verifyElementPresent(findTestObject('assert/dateSelectionClicked'), 5)

CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(findTestObject('homePage/fromDate'), 5)

//log.logWarning(CustomKeywords.'genericUtil.GenericUtil.isElementPresent'(findTestObject('homePage/toDate'), 2))
while (!(CustomKeywords.'genericUtil.GenericUtil.isElementPresent'(findTestObject('homePage/toDate'), 2))) {
    CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(findTestObject('homePage/button_nextMonth'), 5)
}

CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(findTestObject('homePage/toDate'), 5)

