package week5_Dataprovider_assignmen5_classrooom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass {
	@BeforeTest
	public void setFileName() 
	{
		workbookname ="DuplicateLead";

	}
	@Test(dataProvider="fetchData")
	
	public void runDuplicateLead(String phnum)  throws InterruptedException {
			
			driver.findElementByLinkText("Leads").click();
			driver.findElementByLinkText("Find Leads").click();
			driver.findElementByXPath("//span[text()='Phone']").click();
			driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phnum);
			driver.findElementByXPath("//button[text()='Find Leads']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
			driver.findElementByLinkText("Duplicate Lead").click();
			driver.findElementByName("submitButton").click();
			

	}

}


