import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// 1. Khởi tạo trình duyệt
WebUI.openBrowser('')
WebUI.maximizeWindow()

// 2. Gọi Test Case Login (Đảm bảo TC_Login_DDT đã xóa WebUI.closeBrowser())
WebUI.callTestCase(findTestCase('Test Cases/Huy/01_Authentication/TC_Login_DDT'), [('vEmail') : 'admin@gmail.com', ('vPassword') : '123456', ('vExpected') : 'Dashboard'], FailureHandling.STOP_ON_FAILURE)

// 3. Điều hướng: Click Menu Customer -> Click Add Customer
WebUI.click(findTestObject('Object Repository/Page_Customerlist/Page_Dashboard/a_Customer'))
WebUI.click(findTestObject('Object Repository/Page_Customerlist/Page_Dashboard/a_Add Customer'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_CustomerName'), 10)

// 4. Nhập liệu Full Form từ Variables
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_CustomerName'), vName)
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_Email'), vEmail)
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_Phone_phone'), vPhone)
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_Address1'), vAddress1)
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_Fax_fax'), vFax)
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_State_state'), vState)
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_Country_country'), vCountry)
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_MobileNo'), vMobile)
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_VAT NO_email_address'), vVatNo)
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_CR NO_contact'), vCrNo)
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_Address2'), vAddress2)
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_City_city'), vCity)
WebUI.setText(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/input_Zip code_zip'), vZip)

// 5. Lưu thông tin
WebUI.click(findTestObject('Object Repository/Page_Customerlist/Page_Add Customer/button_Save'))

// 6. Xử lý Alert "failed!" (Nếu có Alert hiện lên thì đóng nó để không bị lỗi Browser)
if (WebUI.verifyAlertPresent(3, FailureHandling.OPTIONAL)) {
    WebUI.acceptAlert()
}

// 7. Kiểm tra kết quả mong đợi
WebUI.delay(2)
WebUI.verifyTextPresent(vExpected, false, FailureHandling.OPTIONAL)

// 8. Đóng trình duyệt sau khi xong
WebUI.closeBrowser()