import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Open browser
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

// Click Service menu
WebUI.click(findTestObject('Page_Dashboard/a_Service'))

// Open Manage Service Invoice
WebUI.executeJavaScript(
"document.querySelector(\"a[href*='manage_service_invoice']\").click()",
null)

// Wait page load
WebUI.delay(3)

// Verify Service Invoice page
WebUI.verifyTextPresent('Service Invoice', false)

// Close browser
WebUI.closeBrowser()