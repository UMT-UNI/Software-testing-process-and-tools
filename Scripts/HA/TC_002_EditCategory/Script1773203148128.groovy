import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'pack.Login.loginToWebsiteGlobalVariable'()

CustomKeywords.'pack.Category.CategoryListDirect'()

WebUI.click(findTestObject('TC Product/Page_Manage Category/a_viewCategoryId'))

WebUI.setText(findTestObject('TC Product/Page_Category_id/input__CategoryName'), categoryName)

WebUI.click(findTestObject('TC Product/Page_Add Category/span_Active'))

WebUI.setText(findTestObject('TC Product/Page_Add Category/input__Set Status'), status)

WebUI.sendKeys(findTestObject('TC Product/Page_Add Category/input__Set Status'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('TC Product/Page_Category_id/btn_Update'))


if (expectedResult == 'success') {
    WebUI.verifyElementPresent(findTestObject('Object Repository/TC Product/Page_Add Category/div_You Are In Demo Mode'), 0)
	
	WebUI.comment("Success with " + categoryName)
} else {
    WebUI.verifyElementPresent(findTestObject('Object Repository/TC Product/Page_Add Category/div_You Are In Demo Mode'), 0)
	
	WebUI.comment("Fail like expected with " + categoryName)
}

WebUI.closeBrowser()

