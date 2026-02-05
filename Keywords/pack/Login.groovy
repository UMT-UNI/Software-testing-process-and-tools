package pack

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable


public class Login {
	@Keyword
	def static void loginToWebsite(String url,String username,String password) {
		WebUI.openBrowser(url)
		WebUI.waitForPageLoad(GlobalVariable.waitPresentTimeout)
		WebUI.maximizeWindow()
		
		WebUI.sendKeys(findTestObject('Page_Login/input_Email_email'), username)
		WebUI.sendKeys(findTestObject('Page_Login/input_Password_password'), password)
		WebUI.click(findTestObject('Page_Login/button_Login'))
		WebUI.delay(1)
	}
		
	@Keyword
	def static void loginToWebsiteGlobalVariable() {
		loginToWebsite(GlobalVariable.url, GlobalVariable.username, GlobalVariable.password)
	}
}