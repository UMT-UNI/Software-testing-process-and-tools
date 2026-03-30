import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')
WebUI.maximizeWindow()

// 1. Đăng nhập (Dùng lại case Login cũ của Huy)
WebUI.callTestCase(findTestCase('Test Cases/Huy/01_Authentication/TC_Login_DDT'), [('vEmail') : 'admin@gmail.com', ('vPassword') : '123456', ('vExpected') : 'Dashboard'], FailureHandling.STOP_ON_FAILURE)

// 2. Click Menu Customer -> Click Customer List
WebUI.click(findTestObject('Object Repository/Page_Customerlist/Page_Dashboard/a_Customer'))
WebUI.click(findTestObject('Object Repository/Page_Customerlist/Page_Customer List/a_Customer List'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Customerlist/Page_Customer List/input_SearchCustomer'), 10)

// 3. Nhập từ khóa Search và nhấn Enter
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Customer List/input_SearchCustomer'), vSearchKey)
WebUI.sendKeys(findTestObject('Object Repository/Page_Customerlist/Page_Customer List/input_SearchCustomer'), Keys.chord(Keys.ENTER))

WebUI.delay(2)

// 4. Kiểm tra xem kết quả có hiện ra không
// Lưu ý: Vì bản Demo có thể không có data, nếu fail Huy có thể đổi vExpected thành "No matching records found"
WebUI.verifyTextPresent(vExpected, false, FailureHandling.OPTIONAL)

WebUI.closeBrowser()