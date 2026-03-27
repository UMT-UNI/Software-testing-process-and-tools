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

WebUI.navigateToUrl('https://saleserpdemo.bdtask-demo.com/v10_demo/login')

WebUI.setText(findTestObject('Page_/input_Email'), 'admin@gmail.com')

WebUI.click(findTestObject('Page_/input_Password'))

WebUI.setEncryptedText(findTestObject('Page_/input_Password'), 'aeHFOx8jV/A=')

WebUI.click(findTestObject('Page_/button_Login'))

WebUI.click(findTestObject('Page_Dashboard/a_Service'))

WebUI.click(findTestObject('Page_Dashboard/a_Add Service'))

WebUI.setText(findTestObject('Page_Add Service/input_Service Name'), 'Test Service')

WebUI.setText(findTestObject('Page_Add Service/input_Charge'), '100')

WebUI.click(findTestObject('Page_Add Service/input_add-service'))

WebUI.verifyElementText(findTestObject('Page_Add Service/input_Description_add-service'), '')

WebUI.closeBrowser()

