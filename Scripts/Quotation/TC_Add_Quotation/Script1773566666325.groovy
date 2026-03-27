import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

// Open Browser
WebUI.openBrowser('')

// Navigate to login page
WebUI.navigateToUrl('https://saleserpdemo.bdtask-demo.com/v10_demo/login')

// Wait login page load
WebUI.waitForElementVisible(findTestObject('Page_/input_Email'), 10)

// Login
WebUI.setText(findTestObject('Page_/input_Email'), 'admin@gmail.com')

WebUI.setText(findTestObject('Page_/input_Password'), '123456')

WebUI.click(findTestObject('Page_/button_Login'))

// Click Add Quotation (trực tiếp)
WebUI.click(findTestObject('Page_Dashboard/span_Quotation'))

WebUI.click(findTestObject('Page_Dashboard/a_Add Quotation'))

// Wait page load
WebUI.delay(3)

// Verify page Add Quotation
WebUI.verifyTextPresent('Quotation', false)

// Close browser
WebUI.closeBrowser()

