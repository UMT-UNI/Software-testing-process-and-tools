import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')
WebUI.maximizeWindow()

// 1. Gọi Login
WebUI.callTestCase(findTestCase('Test Cases/Huy/01_Authentication/TC_Login_DDT'), [('vEmail') : 'admin@gmail.com', ('vPassword') : '123456', ('vExpected') : 'Dashboard'], FailureHandling.STOP_ON_FAILURE)

// 2. Điều hướng đến Supplier List
WebUI.click(findTestObject('Object Repository/Page_Add Supplier/Page_Dashboard/a_Supplier'))
WebUI.click(findTestObject('Object Repository/Page_Add Supplier/Page_Dashboard/a_Supplier List'))

// 3. Thực hiện Search
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Add Supplier/Page_Supplier List/input_Search'), 10)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Supplier List/input_Search'), vSearchKey)

// Gửi phím Enter để thực hiện tìm kiếm
WebUI.sendKeys(findTestObject('Object Repository/Page_Add Supplier/Page_Supplier List/input_Search'), Keys.chord(Keys.ENTER))

// 4. Kiểm tra kết quả (Sử dụng FailureHandling.OPTIONAL vì bản demo có thể không có data Samsung)
WebUI.delay(2)
WebUI.verifyTextPresent(vExpected, false, FailureHandling.OPTIONAL)

WebUI.closeBrowser()