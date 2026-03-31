import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

WebUI.openBrowser('')
WebUI.maximizeWindow()

// 1. Gọi Login
WebUI.callTestCase(findTestCase('Test Cases/Huy/01_Authentication/TC_Login_DDT'), [('vEmail') : 'admin@gmail.com', ('vPassword') : '123456', ('vExpected') : 'Dashboard'], FailureHandling.STOP_ON_FAILURE)

// 2. Điều hướng đến trang Sale Terms List
WebUI.click(findTestObject('Object Repository/Page_New_Sale/Page_Dashboard/a_Sale'))
WebUI.click(findTestObject('Object Repository/Page_New_Sale/Page_Dashboard/a_Sales Terms List'))

// 3. Kiểm tra xem đã vào đúng trang chưa
WebUI.delay(2)
// Kiểm tra tiêu đề trang hoặc text "Sale Terms List" có hiển thị không
WebUI.verifyTextPresent(vExpected, false, FailureHandling.OPTIONAL)

WebUI.closeBrowser()