package pack

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

public class Unit {
	@Keyword
	def static void AddUnitDirect() {
		WebUI.click(findTestObject('Object Repository/TC Product/Page_Dashboard/a_Product'))

		WebUI.click(findTestObject('Object Repository/TC Product/Page_Dashboard/a_Add Unit'))
	}
	
	@Keyword
	def static void UnitListDirect() {
		WebUI.click(findTestObject('Object Repository/TC Product/Page_Dashboard/a_Product'))
		
		WebUI.click(findTestObject('Object Repository/TC Product/Page_Dashboard/a_Unit List'))
	}
}