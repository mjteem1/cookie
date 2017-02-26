package Teamwork.cookie;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LetMeRemember {

	private WebDriver driver;
	@SuppressWarnings("unused")
	private WebDriverWait wait;
	
	public LetMeRemember(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;
		
	}
	
	By userName = By.id("userName");
	By password = By.id("password");

	By className = By.className("ladda-label");
	By addProject = By.xpath("//button[@data-bind='click:OnClickAddProject']");
	By projectName = By.id("newProjectName");
	By saveProject = By.xpath("//button[@type='submit']");
	By addTaskList = By.xpath("//button[@data-bind='click:OnClickAddTaskList']");
	By submit = By.xpath("//button[@type='submit']");
	By addFirstTask = By.xpath("//button[contains(.,'Add the First Task')]");
	By addTaskName = By.xpath("//input[contains(@data-required,'true')]");
	By taskCompleteUncomplete = By.xpath("//i[@class='fa fa-check no-print']");
	By milestonePage = By.linkText("MILESTONES");
	By addMilestone = By.xpath("//button[contains(.,'Add Milestone')]");
	By addMilestoneName = By.id("milestoneName");


	public WebElement className() {

		return driver.findElement(className);
	}

	public WebElement addProject() {

		return driver.findElement(addProject);
	}

	public WebElement projectName() {

		return driver.findElement(projectName);
	}
	
	public WebElement userName() {

		return driver.findElement(userName);
	}
	
	public WebElement password() {

		return driver.findElement(password);
	}


	
	public void enterName(String name) {
		
		userName().sendKeys(name);
		
	}
	
	public void enterPassword(String password) {
		
		password().sendKeys(password);
		
	}
	
//	public ExpectedCondition<List<WebElement>> wait(By stuff) {
//
//		return ExpectedConditions.visibilityOfAllElementsLocatedBy(stuff);
//		
//	}
//	

public void click(WebDriver driver, By by) {
    (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
    driver.findElement(by).click();
}

public void type(WebDriver driver, By by, String stuff) {
	(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
	driver.findElement(by).sendKeys(stuff);
}

//	public ExpectedCondition<WebElement> wait(By stuff) {
//
//		return ExpectedConditions.visibilityOfElementLocated(stuff);
//	}
}



