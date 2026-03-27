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

WebUI.setEncryptedText(findTestObject('Page_/input_Password'), 'aeHFOx8jV/A=')

WebUI.click(findTestObject('Page_/button_Login'))

// Click Service menu
WebUI.waitForElementClickable(findTestObject('Page_Dashboard/a_Service'), 10)

WebUI.click(findTestObject('Page_Dashboard/a_Service'))

// Click Service Invoice bằng javascript (tránh lỗi menu)
WebUI.executeJavaScript('document.querySelector("a[href*=\'service_invoice\']").click()', null)

// Wait page load
WebUI.delay(3)

// Chọn service bằng javascript
WebUI.executeJavaScript('document.querySelector(\'select\').selectedIndex = 1; document.querySelector(\'select\').dispatchEvent(new Event(\'change\'));', 
    null)

// Click Save
WebUI.click(findTestObject('Page_Service Invoice/input_Add New Payment Method_add_invoice'))

// Verify invoice tạo thành công
WebUI.verifyTextPresent('Invoice', false)

// Close Browser
WebUI.closeBrowser()

