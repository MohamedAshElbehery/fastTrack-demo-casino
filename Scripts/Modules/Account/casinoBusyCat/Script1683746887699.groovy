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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.waitForElementVisible(findTestObject('Account/navPanel_div'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/navPanel_div'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/navPanel_div'))

WebUI.waitForElementVisible(findTestObject('Account/Casino/casinoOption_a'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Casino/casinoOption_a'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Casino/casinoOption_a'))

WebUI.waitForPageLoad(GlobalVariable.globalTimeOut, FailureHandling.STOP_ON_FAILURE)

assert WebUI.getUrl() == 'https://demo.ft-crm.com/casino'

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('Account/Casino/game_iframe'), GlobalVariable.globalTimeOut)

WebUI.switchToFrame(findTestObject('Account/Casino/game_iframe'), GlobalVariable.globalTimeOut)

initialWonBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Casino/gameBalance_div'))

initialWonBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
	 [('desiredString'):initialWonBalanceBeforeCleaning, ('value'):'[€ ]', ('arrayIndex'):3])

WebUI.waitForElementVisible(findTestObject('Account/Casino/busyCat_img'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Casino/busyCat_img'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Casino/busyCat_img'))

WebUI.delay(5)

finalWonBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Casino/gameBalance_div'))

finalWonBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
	[('desiredString'):finalWonBalanceBeforeCleaning, ('value'):'[€ ]', ('arrayIndex'):3])

assert Integer.parseInt(finalWonBalanceAfterCleaning) > Integer.parseInt(initialWonBalanceAfterCleaning)

initialLostBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Casino/gameBalance_div'))

initialLostBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
	 [('desiredString'):initialLostBalanceBeforeCleaning, ('value'):'[€ ]', ('arrayIndex'):3])

WebUI.waitForElementVisible(findTestObject('Account/Casino/nonBusyCat_img'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Casino/nonBusyCat_img'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Casino/nonBusyCat_img'))

WebUI.delay(5)

finalLostBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Casino/gameBalance_div'))

finalLostBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
	[('desiredString'):finalLostBalanceBeforeCleaning, ('value'):'[€ ]', ('arrayIndex'):3])

assert Integer.parseInt(finalLostBalanceAfterCleaning) == Integer.parseInt(initialLostBalanceAfterCleaning) - 5

