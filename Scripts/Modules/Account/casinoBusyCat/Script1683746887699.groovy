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

//Smart waiting for navigation panel and click
WebUI.waitForElementVisible(findTestObject('Account/navPanel_div'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/navPanel_div'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/navPanel_div'))

//Smart waiting for casino option and click
WebUI.waitForElementVisible(findTestObject('Account/Casino/casinoOption_a'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Casino/casinoOption_a'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Casino/casinoOption_a'))

//Waiting for the game page to load
WebUI.waitForPageLoad(GlobalVariable.globalTimeOut, FailureHandling.STOP_ON_FAILURE)

//Asserting that the casino option button worked and we got redirected to the right URL
assert WebUI.getUrl() == 'https://demo.ft-crm.com/casino'

//Refreshing because the page is flaky sometimes
WebUI.refresh()

//Waiting for the iframe to be present in DOM
WebUI.waitForElementPresent(findTestObject('Account/Casino/game_iframe'), GlobalVariable.globalTimeOut)

//Switiching to the game iframe to be able to interact with it's components
WebUI.switchToFrame(findTestObject('Account/Casino/game_iframe'), GlobalVariable.globalTimeOut)

//Getting the initial balance and clean it to be able to use it for balance assertions
initialWonBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Casino/gameBalance_div'))

//Calling the string split module and sending it the split at values and the index of the number of interest
initialWonBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
	 [('desiredString'):initialWonBalanceBeforeCleaning, ('value'):'[€ ]', ('arrayIndex'):3])

//Smart waiting for the busy cat and click
WebUI.waitForElementVisible(findTestObject('Account/Casino/busyCat_img'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Casino/busyCat_img'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Casino/busyCat_img'))

//We had to use a hard delay here to wait for balance to be updated correctly
WebUI.delay(5)

//Getting the final balance and clean it to be able to use it for balance assertions
finalWonBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Casino/gameBalance_div'))

finalWonBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
	[('desiredString'):finalWonBalanceBeforeCleaning, ('value'):'[€ ]', ('arrayIndex'):3])

//asserting that the final balance is greater than the initial balance after winning the game
assert Integer.parseInt(finalWonBalanceAfterCleaning) > Integer.parseInt(initialWonBalanceAfterCleaning)

//Getting the balance before losing the game
initialLostBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Casino/gameBalance_div'))

initialLostBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
	 [('desiredString'):initialLostBalanceBeforeCleaning, ('value'):'[€ ]', ('arrayIndex'):3])

//Smart waiting for the wrong cat and click
WebUI.waitForElementVisible(findTestObject('Account/Casino/nonBusyCat_img'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Casino/nonBusyCat_img'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Casino/nonBusyCat_img'))

WebUI.delay(5)

finalLostBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Casino/gameBalance_div'))

finalLostBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
	[('desiredString'):finalLostBalanceBeforeCleaning, ('value'):'[€ ]', ('arrayIndex'):3])

//asserting that the balance after losing is 5 euros less than the initial balance
assert Integer.parseInt(finalLostBalanceAfterCleaning) == Integer.parseInt(initialLostBalanceAfterCleaning) - 5

