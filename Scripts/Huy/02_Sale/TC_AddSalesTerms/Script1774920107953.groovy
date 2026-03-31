import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

WebUI.openBrowser('')
WebUI.maximizeWindow()

// 1. Gọi Login
WebUI.callTestCase(findTestCase('Test Cases/Huy/01_Authentication/TC_Login_DDT'), [('vEmail') : 'admin@gmail.com', ('vPassword') : '123456', ('vExpected') : 'Dashboard'], FailureHandling.STOP_ON_FAILURE)

// 2. Điều hướng (Đúng đường dẫn Huy cung cấp)
WebUI.click(findTestObject('Object Repository/Page_New_Sale/Page_Dashboard/a_Sale'))
WebUI.click(findTestObject('Object Repository/Page_New_Sale/Page_Dashboard/a_Add Sales Terms'))

// 3. Nhập liệu và Save
WebUI.setText(findTestObject('Object Repository/Page_New_Sale/Page_Add Sales Terms/text_term'), vTermName)
WebUI.click(findTestObject('Object Repository/Page_New_Sale/Page_Add Sales Terms/button_Save'))

// 4. Xử lý Alert Demo
if (WebUI.verifyAlertPresent(3, FailureHandling.OPTIONAL)) {
    WebUI.acceptAlert()
}

// 5. Kiểm tra kết quả
WebUI.delay(2)
WebUI.verifyTextPresent(vExpected, false, FailureHandling.OPTIONAL)

WebUI.closeBrowser()