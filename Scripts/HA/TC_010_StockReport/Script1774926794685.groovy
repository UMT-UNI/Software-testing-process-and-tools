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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.testng.Assert as Assert
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.io.File

String downloadPath = 'C:\\Users\\sayho\\Downloads'

CustomKeywords.'pack.Login.loginToWebsiteGlobalVariable'()

WebUI.click(findTestObject('TC Product/Page_Dashboard/a_Stock'))

WebUI.click(findTestObject('TC Product/Page_Dashboard/a_Stock Report'))

if (filetype == "csv") {
	WebUI.click(findTestObject('Object Repository/TC Product/Page_Stock Report/a_CSV'))
} else if (filetype == "excel") {
	WebUI.click(findTestObject('Object Repository/TC Product/Page_Stock Report/a_Excel'))
} else {
	WebUI.click(findTestObject('Object Repository/TC Product/Page_Stock Report/a_PDF'))
}
WebUI.delay(5)

if (filetype == "csv") {
	Assert.assertTrue(isFileDownloaded(downloadPath, 'StockList.csv'), 'Failed to download Expected document')
} else if (filetype == "excel") {
	Assert.assertTrue(isFileDownloaded(downloadPath, 'StockList.xlsx'), 'Failed to download Expected document')
} else {
	Assert.assertTrue(isFileDownloaded(downloadPath, 'Stock List.pdf'), 'Failed to download Expected document')
}


def isFileDownloaded(String downloadPath, String fileName) {
    File dir = new File(downloadPath);
    File[] dirContents = dir.listFiles();

    for (int i = 0; i < dirContents.length; i++) {
        if (dirContents[i].getName().equals(fileName)) {
            // File đã tồn tại, xóa đi để lần test sau không bị lẫn (tùy chọn)
            // dirContents[i].delete();
            return true;
        }
    }
    return false;
}