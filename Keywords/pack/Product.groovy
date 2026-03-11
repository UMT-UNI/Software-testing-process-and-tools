package pack

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

public class Product {
	@Keyword
	def static void AddProductDirect() {
		WebUI.click(findTestObject('Object Repository/TC Product/Page_Dashboard/toggle_Product'))

		WebUI.click(findTestObject('Object Repository/TC Product/Page_Dashboard/a_Add Product'))
	}
	
	@Keyword
	def static void AddProductCSVDirect() {
		WebUI.click(findTestObject('Object Repository/TC Product/Page_Dashboard/toggle_Product'))

		WebUI.click(findTestObject('Object Repository/TC Product/Page_Dashboard/a_Add Product (CSV)'))
	}
	
	@Keyword
	def static void ProductListDirect() {
		WebUI.click(findTestObject('Object Repository/TC Product/Page_Dashboard/toggle_Product'))
		
		WebUI.click(findTestObject('Object Repository/TC Product/Page_Dashboard/a_Product List'))
	}
}