package Teamwork.cookie;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TryAgain {

	private WebDriver driver;
	private WebDriverWait wait;
	private DateFormat dateformat;
	private static LetMeRemember letmeremember;


	@BeforeClass
	@org.testng.annotations.Parameters(value = {"browser", "os_version", "os"})
	public void setUp(String browser, String os_version, String os) throws Exception {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("browserName", browser);
		capability.setCapability("os_version", os_version);
		capability.setCapability("os", os);
		capability.setCapability("project", "P1");
		capability.setCapability("build", "1.0");
		capability.setCapability("browserstack.local", true);


		driver = new RemoteWebDriver(
				new URL("https://mjheff1:LuXjLo9YyEC3eXHfWr7r@hub-cloud.browserstack.com/wd/hub"),
				capability);
		wait = new WebDriverWait(driver, 10);
		letmeremember = new LetMeRemember();


		dateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	driver.manage().
			window().
			maximize();

	driver.get("http://sunbeam.teamwork.dev/#/login");

	String title = driver.getTitle();

	System.out.println(title);

	//get current date time with Date()
	Date date = new Date();
	// Now format the date
	String date1 = dateformat.format(date);

	//Assert.assertEquals(title, "Testing");

		//commenting out cookie - because this is using the local version

	/*Cookie cookie = driver.manage().getCookieNamed("PROJLB");
		driver.manage().deleteCookie(cookie);
		driver.manage().addCookie(
		  new Cookie.Builder(cookie.getName(), "beta")
			.domain(cookie.getDomain())
			.expiresOn(cookie.getExpiry())
			.path(cookie.getPath())
			.isSecure(cookie.isSecure())
			.build()); */
		
		//System.out.println(cookie);
		System.out.println(date1);
}

	@Test
	@org.testng.annotations.Parameters(value = {"browser"})
	public void testSimple(String browser) throws Exception {

		Date date = new Date();
		// Now format the date
		String date1 = dateformat.format(date);
		
		letmeremember.type(driver, letmeremember.userName, "mj");
		
		letmeremember.type(driver, letmeremember.password, "test");

		letmeremember.click(driver, letmeremember.className);

		System.out.println("Logged in");
		
		letmeremember.click(driver, letmeremember.addProject);
		
		letmeremember.type(driver, letmeremember.projectName, "Lolly LOL lollY - created (" + date1 + " " + browser + ")");
		
		letmeremember.click(driver, letmeremember.saveProject);
		
		letmeremember.click(driver, letmeremember.addTaskList);
		
		letmeremember.type(driver, letmeremember.projectName, "Lolly LOL lollY Task List - created (" + date1 + " " + browser + ")");
		
		letmeremember.click(driver, letmeremember.submit);
		
		letmeremember.click(driver, letmeremember.addFirstTask);
		
		letmeremember.type(driver, letmeremember.addTaskName, "I just created a task for the lulz at " + date1 + " " + browser + ")");
		
		letmeremember.click(driver, letmeremember.submit);
		
		letmeremember.click(driver, letmeremember.taskCompleteUncomplete);
		
		letmeremember.click(driver, letmeremember.taskCompleteUncomplete);
		
		letmeremember.click(driver, letmeremember.milestonePage);
		
		letmeremember.click(driver, letmeremember.addMilestone);
		
		letmeremember.type(driver, letmeremember.addMilestoneName, "Here be a Milestone created on " + date1 + " " + browser + ")");
		
		letmeremember.click(driver, letmeremember.clickAdd);
		
		letmeremember.click(driver, letmeremember.milestoneComplete);
		
		letmeremember.click(driver, letmeremember.viewCompletedMilestone);
		
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
}
