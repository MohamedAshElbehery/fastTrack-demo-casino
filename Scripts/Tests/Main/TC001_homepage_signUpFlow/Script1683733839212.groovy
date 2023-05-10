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

//Calling the create random number module to use this number to create random unique emails
String randomNumber = WebUI.callTestCase(findTestCase('Modules/Helpers/generateRandomNumberModule'), [:])

String newEmail = 'elbehery.muhammed+demo_' + randomNumber + '@gmail.com'

//opening browser and maximizing window
WebUI.openBrowser('https://demo.ft-crm.com/', FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

//calling the signup module and sending the signup parameters
WebUI.callTestCase(findTestCase('Modules/Main/signUpModule'), [
	('newEmail'): newEmail,
	('newPhoneExtension'):newPhoneExtension,
	('newPhoneNumber'):newPhoneNumber,
	('newName'):newName,
	('newPassword'):newPassword
	], FailureHandling.STOP_ON_FAILURE)

//navigating to home page
WebUI.navigateToUrl('https://demo.ft-crm.com/')

//calling the login module and try to login with the newly created account
WebUI.callTestCase(findTestCase('Test Cases/Modules/Main/logInModule'), [('loginEmail'):newEmail], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()



