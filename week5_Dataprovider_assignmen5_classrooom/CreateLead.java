package week5_Dataprovider_assignmen5_classrooom;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {
	@BeforeTest
	public void setFileName() {
		workbookname ="CreateLeadnew";

	}

	@Test(dataProvider="fetchData")
	public void runCreateLead(String company,String Fname,String Lname)  {
		// TODO Auto-generated method stub
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(company);
		driver.findElementById("createLeadForm_firstName").sendKeys(Fname);
		driver.findElementById("createLeadForm_lastName").sendKeys(Lname);
		driver.findElementByName("submitButton").click();
		

	
}
	
	
}
