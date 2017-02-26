package Teamwork.cookie;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TryAgain {
	
	static WebDriver driver;
	static WebDriverWait wait;
	static DateFormat dateformat;
	public static LetMeRemember letmeremember;
	
	
	public static void main (String[] args) {
		
		

		System.setProperty("webdriver.chrome.driver", "C:/Users/MJ/Jars/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,10);
		letmeremember = new LetMeRemember(driver, wait);
		dateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		driver.manage().window().maximize();
		driver.get("https://twtest.teamwork.com/#/login");
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		//get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateformat.format(date);
		
		//Assert.assertEquals(title, "Testing");
				
		Cookie cookie = driver.manage().getCookieNamed("PROJLB");
		driver.manage().deleteCookie(cookie);
		driver.manage().addCookie(
		  new Cookie.Builder(cookie.getName(), "beta")
		    .domain(cookie.getDomain())
		    .expiresOn(cookie.getExpiry())
		    .path(cookie.getPath())
		    .isSecure(cookie.isSecure())
		    .build()
		);
		
		System.out.println(cookie);
		
		System.out.println(date1);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(letmeremember.userName));
		//letmeremember.wait(letmeremember.userName);
		
		//http://www.ontestautomation.com/using-wrapper-methods-for-better-error-handling-in-selenium/
		
		
		
		letmeremember.type(driver, letmeremember.userName, "mj");
		
		letmeremember.type(driver, letmeremember.password, "test");
				
		//letmeremember.enterName("mj");
		
		
		//letmeremember.wait(letmeremember.className);
		letmeremember.click(driver, letmeremember.className);
		
		letmeremember.click(driver, letmeremember.addProject);
		
		letmeremember.type(driver, letmeremember.projectName, "Lolly LOL lollY - created (" + date1 + ")");
		
		letmeremember.click(driver, letmeremember.saveProject);
		
		letmeremember.click(driver, letmeremember.addTaskList);
		
		letmeremember.type(driver, letmeremember.projectName, "Lolly LOL lollY Task List - created (" + date1 + ")");
		
		letmeremember.click(driver, letmeremember.submit);
		
		letmeremember.click(driver, letmeremember.addFirstTask);
		
		letmeremember.type(driver, letmeremember.addTaskName, "I just created a task for the lulz at " + date1);
		
		letmeremember.click(driver, letmeremember.submit);
		
		letmeremember.click(driver, letmeremember.taskCompleteUncomplete);
		
		letmeremember.click(driver, letmeremember.taskCompleteUncomplete);
		
		letmeremember.click(driver, letmeremember.milestonePage);
		
		letmeremember.click(driver, letmeremember.addMilestone);
		
		letmeremember.type(driver, letmeremember.addMilestoneName, "Here be a Milestone created on " + date1);
		
		letmeremember.click(driver, letmeremember.className);
		
		letmeremember.click(driver, letmeremember.milestoneComplete);
		
		letmeremember.click(driver, letmeremember.viewCompletedMilestone);
		
	}

	
}
