import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

WebUI.openBrowser('')
WebUI.navigateToUrl('https://saleserpdemo.bdtask-demo.com/v10_demo/login')
WebUI.maximizeWindow()

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Login/input_Email_email'), 10)

WebUI.setText(findTestObject('Object Repository/Page_Login/input_Email_email'), vEmail)
WebUI.setText(findTestObject('Object Repository/Page_Login/input_Password_password'), vPassword)
WebUI.click(findTestObject('Object Repository/Page_Login/button_Login'))

WebUI.delay(2)

if (vExpected.contains('Dashboard')) {
    WebUI.verifyTextPresent('Dashboard', false)
} else {
    WebUI.verifyTextPresent(vExpected, false, FailureHandling.OPTIONAL)
}

WebUI.closeBrowser()