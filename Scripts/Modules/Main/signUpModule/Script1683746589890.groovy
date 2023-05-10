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

//smart waiting for the new user button and clicking on it
WebUI.waitForElementVisible(findTestObject('Home Page/newUser_btn'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Home Page/newUser_btn'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Home Page/newUser_btn'))

//smart waiting for the continue button and clicking on it
WebUI.waitForElementVisible(findTestObject('Home Page/continue_btn'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Home Page/continue_btn'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Home Page/continue_btn'))

//smart waiting for the enter email input and writing the email
WebUI.waitForElementVisible(findTestObject('Home Page/enterEmail_input'), GlobalVariable.globalTimeOut)

WebUI.setText(findTestObject('Home Page/enterEmail_input'), newEmail)

//smart waiting for the submit button ancd clicking on it
WebUI.waitForElementVisible(findTestObject('Home Page/submit_btn'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Home Page/submit_btn'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Home Page/submit_btn'))

//smart waiting for the phone extension input and writing the number
WebUI.waitForElementVisible(findTestObject('Home Page/phoneExtension_input'), GlobalVariable.globalTimeOut)

WebUI.setText(findTestObject('Home Page/phoneExtension_input'), newPhoneExtension)

//smart waiting for the phone number input and writing the number
WebUI.waitForElementVisible(findTestObject('Home Page/phoneNumber_input'), GlobalVariable.globalTimeOut)

WebUI.setText(findTestObject('Home Page/phoneNumber_input'), newPhoneNumber)

WebUI.waitForElementVisible(findTestObject('Home Page/submit_btn'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Home Page/submit_btn'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Home Page/submit_btn'))

//smart waiting for the enter name input and writing the name
WebUI.waitForElementVisible(findTestObject('Home Page/enterName_input'), GlobalVariable.globalTimeOut)

WebUI.setText(findTestObject('Home Page/enterName_input'), newName)

WebUI.waitForElementVisible(findTestObject('Home Page/submit_btn'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Home Page/submit_btn'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Home Page/submit_btn'))

//smart waiting for the enter password input and writing the password
WebUI.waitForElementVisible(findTestObject('Home Page/enterPassword_input'), GlobalVariable.globalTimeOut)

WebUI.setText(findTestObject('Home Page/enterPassword_input'), newPassword)

WebUI.waitForElementVisible(findTestObject('Home Page/submit_btn'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Home Page/submit_btn'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Home Page/submit_btn'))

//asserting on the success message
assert WebUI.waitForElementVisible(findTestObject('Home Page/signUpSuccessMessage_h3'), GlobalVariable.globalTimeOut)

//waiting on the login button and clicking on it
WebUI.waitForElementVisible(findTestObject('Home Page/signUpPageLogin_btn'), GlobalVariable.globalTimeOut)

WebUI.waitForElementClickable(findTestObject('Home Page/signUpPageLogin_btn'), GlobalVariable.globalTimeOut)

WebUI.click(findTestObject('Home Page/signUpPageLogin_btn'))

//asserting that the login page header is present to check that the flow is a success
assert WebUI.waitForElementVisible(findTestObject('Home Page/loginPageHeader_h1'), GlobalVariable.globalTimeOut)


