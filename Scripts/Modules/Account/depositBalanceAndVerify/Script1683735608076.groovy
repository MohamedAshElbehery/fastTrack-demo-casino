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

//smart waiting for the balance button 
WebUI.waitForElementVisible(findTestObject('Account/Deposit/balanceButton_btn'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Deposit/balanceButton_btn'), GlobalVariable.globalTimeOut)

//getting the initial balance before depositing the money
initialBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Deposit/balanceButton_btn'))

//cleaning the balance by the string split module at a specific value
initialBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
	 [('desiredString'):initialBalanceBeforeCleaning, ('value'):'[€.]'])

//clicking on the balance button
WebUI.click(findTestObject('Account/Deposit/balanceButton_btn'))

//waiting for the bonus type select and choosing the welcome bonus option
WebUI.waitForElementVisible(findTestObject('Account/Deposit/welcomeBonus_option'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Deposit/welcomeBonus_option'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Deposit/welcomeBonus_option'))

//smart waiting for the card option to be interactive and clicking on it
WebUI.waitForElementVisible(findTestObject('Account/Deposit/cardDeposit_btn'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Deposit/cardDeposit_btn'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Account/Deposit/cardDeposit_btn'))

//waiting for the deposit amount and I made the object not static so we can use it with any value from the 4 values
WebUI.waitForElementVisible(findTestObject('Account/Deposit/depositAmount_btn',[('value'):amount]), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Account/Deposit/depositAmount_btn',[('value'):amount]), GlobalVariable.globalTimeOut)

//clicking on the option with the value passed from the test case
WebUI.click(findTestObject('Account/Deposit/depositAmount_btn',[('value'):amount]))

//if the isDepositFailed flag is equal true the following code will run, the flag is false by default
if(isDepositFailed == true) {
	
	//smart waiting for the failed deposit option and click
	WebUI.waitForElementVisible(findTestObject('Account/Deposit/depositFailed_btn'), GlobalVariable.globalTimeOut)
	
	WebUI.waitForElementClickable(findTestObject('Account/Deposit/depositFailed_btn'), GlobalVariable.globalTimeOut)
	
	WebUI.click(findTestObject('Account/Deposit/depositFailed_btn'))
	
	//assert that the deposit not approved message appeared after clicking on deposit failed button
	assert WebUI.waitForElementVisible(findTestObject('Account/Deposit/depositNotApprovedMessage_h3'), GlobalVariable.globalTimeOut)
	
	//click on the exit button
	WebUI.click(findTestObject('Account/Deposit/depositFormExit_btn'))
	
	//asserting that the current balance is equal to initial balance since it's a failed transaction
	finalBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Deposit/balanceButton_btn'))
	
	finalBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Modules/Helpers/stringSplitAtValue'),
		[('desiredString'):finalBalanceBeforeCleaning, ('value'):'[€.]'])
   
	assert Integer.parseInt(initialBalanceAfterCleaning) == Integer.parseInt(finalBalanceAfterCleaning)
		
} 

else {
	
	//samrt waiting for approve deposit button and click
	WebUI.waitForElementVisible(findTestObject('Account/Deposit/depositApproved_btn'), GlobalVariable.globalTimeOut)
	
	WebUI.waitForElementClickable(findTestObject('Account/Deposit/depositApproved_btn'), GlobalVariable.globalTimeOut)
	
	//scrolling to element to make sure we click on the element of interest
	WebUI.scrollToElement(findTestObject('Account/Deposit/depositApproved_btn'), GlobalVariable.globalTimeOut)
	
	WebUI.click(findTestObject('Account/Deposit/depositApproved_btn'))
	
	WebUI.delay(2)
	
	//asserting that we got the success message after approving the deposit
	assert WebUI.waitForElementVisible(findTestObject('Account/Deposit/depositSuccessMessage_h3'), GlobalVariable.globalTimeOut)
	
	//smart waiting an clicking the OK button
	WebUI.waitForElementClickable(findTestObject('Account/Deposit/depositOK_btn'), GlobalVariable.globalTimeOut)
	
	WebUI.click(findTestObject('Account/Deposit/depositOK_btn'))
	
	//Getting the final balance and cleaning it to be used for assertions
	finalBalanceBeforeCleaning = WebUI.getText(findTestObject('Account/Deposit/balanceButton_btn'))
	
	finalBalanceAfterCleaning = WebUI.callTestCase(findTestCase('Test Cases/Modules/Helpers/stringSplitAtValue'),
		 [('desiredString'):finalBalanceBeforeCleaning, ('value'):'[€.]'])
	
	//asserting that the initial balance + the deposit amount is equal to the final balance
	assert Integer.parseInt(initialBalanceAfterCleaning) + integerAmount == Integer.parseInt(finalBalanceAfterCleaning)

}