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

//Smart waiting for lottery option and click
WebUI.waitForElementVisible(findTestObject('Account/Lottery/lotteryOption_a'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Lottery/lotteryOption_a'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Lottery/lotteryOption_a'))

//asserting that the lottery button is working correctly and we got redirected to the right URL
assert WebUI.getUrl() == 'https://demo.ft-crm.com/lottery'

//Smart waiting for add another ticket button and scrolling to it
WebUI.waitForElementPresent(findTestObject('Account/Lottery/addAnotherTicket_btn'), GlobalVariable.globalTimeOut)

WebUI.scrollToElement(findTestObject('Account/Lottery/addAnotherTicket_btn'), GlobalVariable.globalTimeOut, FailureHandling.STOP_ON_FAILURE)

//getting the initial balance before depositing the money
initialBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Deposit/balanceButton_btn'))

//cleaning the balance by the string split module at a specific value
initialBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
	 [('desiredString'):initialBalanceBeforeCleaning, ('value'):'[€.]'])

//waiting for the draws number and I made the object not static so we can use it with any value
WebUI.waitForElementVisible(findTestObject('Account/Lottery/numberOfDraws_btn',[('value'):drawsValue]), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Lottery/numberOfDraws_btn',[('value'):drawsValue]), GlobalVariable.globalTimeOut)

//clicking on the option with the value passed from the test case
WebUI.click(findTestObject('Account/Lottery/numberOfDraws_btn',[('value'):drawsValue]))

//Smart waiting for lottery option and click on buy ticket button
WebUI.waitForElementVisible(findTestObject('Account/Lottery/buyTicket_btn'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Lottery/buyTicket_btn'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Lottery/buyTicket_btn'))

//delay 2 seconds till the balance updates
WebUI.delay(2)

//asserting that the current balance is equal to initial balance - the draw cost
finalBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Deposit/balanceButton_btn'))

finalBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
	[('desiredString'):finalBalanceBeforeCleaning, ('value'):'[€.]'])

assert Integer.parseInt(initialBalanceAfterCleaning) - drawsCost == Integer.parseInt(finalBalanceAfterCleaning) 
