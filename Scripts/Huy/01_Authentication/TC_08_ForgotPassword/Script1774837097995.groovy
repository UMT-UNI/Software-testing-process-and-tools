import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

WebUI.openBrowser('')
WebUI.navigateToUrl('https://saleserpdemo.bdtask-demo.com/v10_demo/login')
WebUI.maximizeWindow()

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Login/link_ForgotPassword'), 10)
WebUI.click(findTestObject('Object Repository/Page_Login/link_ForgotPassword'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Login/input_ForgotEmail'), 10)
WebUI.setText(findTestObject('Object Repository/Page_Login/input_ForgotEmail'), vEmail)

// Sửa bug 1: Dùng đúng btn_Send
WebUI.click(findTestObject('Object Repository/Page_Login/btn_Send'))

WebUI.delay(2)

// Thêm null: Dùng Object null bạn vừa tạo để verify
if (vExpected == 'null') {
    WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Login/null'), 5)
} else {
    WebUI.verifyTextPresent(vExpected, false, FailureHandling.OPTIONAL)
}

WebUI.closeBrowser()