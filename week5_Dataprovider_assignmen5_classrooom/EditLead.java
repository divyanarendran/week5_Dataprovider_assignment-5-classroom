package week5_Dataprovider_assignmen5_classrooom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends BaseClass
{
	@BeforeTest
	public void setFileName() 
	{
		workbookname ="EditLead";

	}
	
	@Test(dataProvider="fetchData")
	public void runEditLead(String phno,String company) throws InterruptedException {
		
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phno);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(7000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateLeadForm_companyName").sendKeys(company);
		driver.findElementByName("submitButton").click();		
	}

}


