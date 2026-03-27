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

WebUI.openBrowser('')

// Navigate to login page
WebUI.navigateToUrl('https://saleserpdemo.bdtask-demo.com/v10_demo/login')

// Login
WebUI.setText(findTestObject('Page_Login/input_Email'), 'admin@gmail.com')

WebUI.setEncryptedText(findTestObject('Page_Login/input_Password'), 'aeHF0x8jV/A=')

WebUI.click(findTestObject('Page_Login/button_Login'))

// Click Service menu
WebUI.waitForElementClickable(findTestObject('Page_Service/a_Service'), 10)

WebUI.click(findTestObject('Page_Service/a_Service'))

// Click Manage Service
WebUI.waitForElementClickable(findTestObject('Page_Service/a_Manage Service'), 10)

WebUI.click(findTestObject('Page_Service/a_Manage Service'))

// Wait page load
WebUI.delay(2)

// Verify service tồn tại
WebUI.verifyTextPresent('Test Service', false)

// Close browser
WebUI.closeBrowser()

