package week5_Dataprovider_assignmen5_classrooom;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {
	public RemoteWebDriver driver;
	String workbookname;
	@Parameters({"url","username","password"})
	@BeforeMethod
public void commoncode(String url, String uname, String password)
	{
		/*
		 * switch(browser) { case "chrome": {
		 * System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 * driver = new ChromeDriver(); } case "firefox": {
		 * System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		 * driver= new FirefoxDriver(); } }
		 */
		
		  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		  driver = new ChromeDriver();
		 
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
	driver.findElementById("username").sendKeys(uname);
	driver.findElementById("password").sendKeys(password);
	driver.findElementByClassName("decorativeSubmit").click();
	driver.findElementByLinkText("CRM/SFA").click();		
	}
@AfterMethod
public void closeBrowser()
{
	driver.close();	
}
@DataProvider(name="fetchData")
public String[][] sendData() throws IOException
{
	//ReadXcel excel=new ReadXcel();
	//String[][] data = excel.readData();
	return ReadXcel.readData(workbookname);
	}

}

