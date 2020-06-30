package week5_Dataprovider_assignmen5_classrooom;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass {
	@BeforeTest
	public void setFileName() 
	{
		workbookname ="DeleteLead";

	}
	@Test(dataProvider="fetchData")
	public void runDeleteLead(String phonenum)  throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElementByLinkText("Leads").click();
            driver.findElementByLinkText("Find Leads").click();
			driver.findElementByXPath("//span[text()='Phone']").click();
			driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phonenum);
			driver.findElementByXPath("//button[text()='Find Leads']").click();
			Thread.sleep(2000);
			String leadID = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
			driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
			driver.findElementByLinkText("Delete").click();
			driver.findElementByLinkText("Find Leads").click();
			driver.findElementByXPath("//input[@name='id']").sendKeys(leadID);
			driver.findElementByXPath("//button[text()='Find Leads']").click();
			String text = driver.findElementByClassName("x-paging-info").getText();
			if (text.equals("No records to display")) {
				System.out.println("Text matched");
			} else {
				System.out.println("Text not matched");
			}
			

	}

}


