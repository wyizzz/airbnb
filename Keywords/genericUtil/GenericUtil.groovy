package genericUtil

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

import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.util.concurrent.TimeUnit;
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.Keys as Keys

import internal.GlobalVariable

public class GenericUtil {
	KeywordLogger log = new KeywordLogger()

	@Keyword
	def clickUsingJS(TestObject to, int timeout){
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = WebUiCommonHelper.findWebElement(to, timeout)
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		executor.executeScript('arguments[0].click()', element)
	}

	@Keyword
	def isElementPresent(TestObject to, int timeout){
		WebDriver driver = DriverFactory.getWebDriver();
		//		return WebUiCommonHelper.isElementVisibleInViewport(driver, to, timeout)
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		if(driver.findElements(WebUiCommonHelper.buildLocator(to)).size()!=0){
			log.logWarning("Present!");
			return true;
		}
		log.logWarning("not Present");
		return false;
	}

	@Keyword
	def getWebElements(TestObject to){
		WebDriver driver = DriverFactory.getWebDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> elements=driver.findElements(WebUiCommonHelper.buildLocator(to));
		return elements;
	}

	@Keyword
	def inputDataField(TestObject to, String inputData){
		WebDriver driver = DriverFactory.getWebDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement fieldLoc = driver.findElement(WebUiCommonHelper.buildLocator(to));
		fieldLoc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		fieldLoc.sendKeys(Keys.BACK_SPACE);

		for (int i = 0; i < inputData.length(); i++){
			char c = inputData.charAt(i);
			String s = new StringBuilder().append(c).toString();
			fieldLoc.sendKeys(s);
		}
	}

	def Calendar addedDaysDateObject(int days){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, days);
		return c;
	}

}
