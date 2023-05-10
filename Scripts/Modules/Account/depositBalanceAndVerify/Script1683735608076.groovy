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

WebUI.waitForElementVisible(findTestObject('Account/Deposit/balanceButton_btn'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Deposit/balanceButton_btn'), GlobalVariable.globalTimeOut)

initialBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Deposit/balanceButton_btn'))

initialBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
	 [('desiredString'):initialBalanceBeforeCleaning, ('value'):'[€.]'])

WebUI.click(findTestObject('Account/Deposit/balanceButton_btn'))

WebUI.waitForElementVisible(findTestObject('Account/Deposit/welcomeBonus_option'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Deposit/welcomeBonus_option'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Deposit/welcomeBonus_option'))

WebUI.waitForElementVisible(findTestObject('Account/Deposit/cardDeposit_btn'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Deposit/cardDeposit_btn'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Deposit/cardDeposit_btn'))

WebUI.waitForElementVisible(findTestObject('Account/Deposit/depositAmount_btn',[('value'):amount]), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Deposit/depositAmount_btn',[('value'):amount]), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Deposit/depositAmount_btn',[('value'):amount]))

if(isDepositFailed == true) {
	
	WebUI.waitForElementVisible(findTestObject('Account/Deposit/depositFailed_btn'), GlobalVariable.globalTimeOut)
	
	WebUI.waitForElementClickable(findTestObject('Account/Deposit/depositFailed_btn'), GlobalVariable.globalTimeOut)
	
	WebUI.click(findTestObject('Account/Deposit/depositFailed_btn'))
	
	assert WebUI.waitForElementVisible(findTestObject('Account/Deposit/depositNotApprovedMessage_h3'), GlobalVariable.globalTimeOut)
	
	WebUI.click(findTestObject('Account/Deposit/depositFormExit_btn'))
	
	finalBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Deposit/balanceButton_btn'))
	
	finalBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
		[('desiredString'):finalBalanceBeforeCleaning, ('value'):'[€.]'])
   
	assert Integer.parseInt(initialBalanceAfterCleaning) == Integer.parseInt(finalBalanceAfterCleaning)
		
} 

else {
	
	WebUI.waitForElementVisible(findTestObject('Account/Deposit/depositApproved_btn'), GlobalVariable.globalTimeOut)
	
	WebUI.waitForElementClickable(findTestObject('Account/Deposit/depositApproved_btn'), GlobalVariable.globalTimeOut)
	
	WebUI.scrollToElement(findTestObject('Account/Deposit/depositApproved_btn'), GlobalVariable.globalTimeOut)
	
	WebUI.click(findTestObject('Account/Deposit/depositApproved_btn'))
	
	WebUI.delay(2)
	
	assert WebUI.waitForElementVisible(findTestObject('Account/Deposit/depositSuccessMessage_h3'), GlobalVariable.globalTimeOut)
	
	WebUI.waitForElementClickable(findTestObject('Account/Deposit/depositOK_btn'), GlobalVariable.globalTimeOut)
	
	WebUI.click(findTestObject('Account/Deposit/depositOK_btn'))
	
	finalBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Deposit/balanceButton_btn'))
	
	finalBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Test Cases/Modules/Helpers/stringSplitAtValue'),
		 [('desiredString'):finalBalanceBeforeCleaning, ('value'):'[€.]'])
	
	assert Integer.parseInt(initialBalanceAfterCleaning) + integerAmount == Integer.parseInt(finalBalanceAfterCleaning)

}