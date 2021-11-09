package loginTask.Act_global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Login_page {
	
WebDriver driver ;
	WebElement userName;
	WebElement password;
	WebElement loginBtn;
	@BeforeTest
	public void openBrowser() {
		 System.setProperty("webdriver.chrome.driver",
		            "C:\\Users\\Ahmed\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("login test case useing data provider one time with valid data to pass ")
	private void loginWithValidData() {
		 userName = driver.findElement(By.id("username"));
		 password = driver.findElement(By.id("password"));
		 loginBtn = driver.findElement(By.tagName("Button"));
		userName.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");

		loginBtn.click();
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());

	}
	@Test(priority = 2)
	@Severity(SeverityLevel.CRITICAL)
	@Description("login test case useing data provider one time with invalid data to fail")
	private void loginWithInvalidData() {

		 userName = driver.findElement(By.id("username"));
		 password = driver.findElement(By.id("password"));
		 loginBtn = driver.findElement(By.tagName("Button"));
		
		userName.sendKeys("Ahmed");
		password.sendKeys("SuperSecretPassword!");
		
		loginBtn.click();
	}
	
	
	@AfterTest
	private void closeBrowser() {
		driver.quit();

	}
	

}
