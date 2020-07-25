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

CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(findTestObject('searchResultsPage/button_price'), 5)

CustomKeywords.'genericUtil.GenericUtil.inputDataField'(findTestObject('searchResultsPage/input_minimumPrice'), minimumPrice)
CustomKeywords.'genericUtil.GenericUtil.inputDataField'(findTestObject('searchResultsPage/input_maximumPrice'), maximumPrice)

CustomKeywords.'genericUtil.GenericUtil.clickUsingJS'(findTestObject('searchResultsPage/button_savePriceFilters'), 5)

WebUI.verifyElementPresent(findTestObject('searchResultsPage/assert/priceFilterIsApplied'), 5)

