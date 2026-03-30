import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

WebUI.openBrowser('')
WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('Test Cases/Huy/01_Authentication/TC_Login_DDT'), [('vEmail') : 'admin@gmail.com', ('vPassword') : '123456', ('vExpected') : 'Dashboard'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Add Supplier/Page_Dashboard/a_Supplier'))
WebUI.click(findTestObject('Object Repository/Page_Add Supplier/Page_Dashboard/Add Supplier'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_SupplierName'), 10)

WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_SupplierName'), vSupName)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_MobileNo'), vMobile)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_Email'), vEmail)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_VatNo'), vVatNo)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_Phone'), vPhone)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_Contact'), vContact)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_Address1'), vAddress1)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_Address2'), vAddress2)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_Fax'), vFax)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_City'), vCity)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_State'), vState)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_ZipCode'), vZip)
WebUI.setText(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/input_Country'), vCountry)

WebUI.click(findTestObject('Object Repository/Page_Add Supplier/Page_Add Supplier/button_Save'))

if (WebUI.verifyAlertPresent(3, FailureHandling.OPTIONAL)) {
    WebUI.acceptAlert()
}

WebUI.delay(2)
WebUI.verifyTextPresent(vExpected, false, FailureHandling.OPTIONAL)

WebUI.closeBrowser()