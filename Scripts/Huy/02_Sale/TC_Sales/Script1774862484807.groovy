import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')
WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('Test Cases/Huy/01_Authentication/TC_Login_DDT'), [('vEmail') : 'admin@gmail.com', ('vPassword') : '123456', ('vExpected') : 'Dashboard'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_New_Sale/Page_Dashboard/a_Sale'))
WebUI.click(findTestObject('Object Repository/Page_New_Sale/Page_Dashboard/a_New Sale'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_New_Sale/Page_Add Invoice/select_Customer'), 10)

// Xử lý chọn Customer dạng Input Search
if (vCustomer != '') {
    WebUI.setText(findTestObject('Object Repository/Page_New_Sale/Page_Add Invoice/select_Customer'), vCustomer)
    WebUI.sendKeys(findTestObject('Object Repository/Page_New_Sale/Page_Add Invoice/select_Customer'), Keys.chord(Keys.ENTER))
}

// Xử lý chọn Product dạng Input Search
WebUI.setText(findTestObject('Object Repository/Page_New_Sale/Page_Add Invoice/select_Product'), vProduct)
WebUI.sendKeys(findTestObject('Object Repository/Page_New_Sale/Page_Add Invoice/select_Product'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Object Repository/Page_New_Sale/Page_Add Invoice/input_Qty'), vQty)

WebUI.click(findTestObject('Object Repository/Page_New_Sale/Page_Add Invoice/button_Submit'))

if (WebUI.verifyAlertPresent(3, FailureHandling.OPTIONAL)) {
    WebUI.acceptAlert()
}

WebUI.delay(2)
WebUI.verifyTextPresent(vExpected, false, FailureHandling.OPTIONAL)

WebUI.closeBrowser()