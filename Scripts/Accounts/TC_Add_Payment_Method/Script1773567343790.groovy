import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

// Wait dashboard load
WebUI.delay(3)

// Wait Accounts menu
WebUI.waitForElementClickable(findTestObject('Page_Dashboard/a_Accounts'), 10)

// Click Accounts
WebUI.click(findTestObject('Page_Dashboard/a_Accounts'))

// Click Add Payment Method
WebUI.click(findTestObject('Page_Dashboard/a_Add Payment Method'))

// Wait page load
WebUI.delay(3)

// Verify page Add Payment Method
WebUI.verifyTextPresent('Payment Method', false)

// Close Browser
WebUI.closeBrowser()

