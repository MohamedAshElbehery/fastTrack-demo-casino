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

//Open browser and maximizing window
WebUI.openBrowser('https://demo.ft-crm.com/', FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

//user login
WebUI.callTestCase(findTestCase('Test Cases/Modules/Main/logInModule'), [('loginEmail'):loginEmail], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

//calling the lottery module and choosing the draws value = 2 which means 2 draws and costs 10 euros
WebUI.callTestCase(findTestCase('Modules/Account/buyLotteryTicketAndVerifyBalance'), [('drawsValue'):drawsValue,
	 ('drawsCost'):drawsCost], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()
