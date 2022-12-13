package com.genericlib.demoblaze;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public FileLib fl=new FileLib();
	public CommonUtils cu=new CommonUtils();
	public static String ProductName;
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	
	@BeforeTest(groups = {"smoke","regression"})
	public void configBS() throws IOException {
		report=new ExtentReports();
		spark=new ExtentSparkReporter("Demoblaze.html");
		report.attachReporter(spark);
		if(fl.getDataFromProperties("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		if(fl.getDataFromProperties("browser").equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.get(fl.getDataFromProperties("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Reporter.log("Launched the browser", true);
	}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void configBM() throws IOException, InterruptedException {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("loginusername")).sendKeys(fl.getDataFromProperties("username"));
		Thread.sleep(1000);
		driver.findElement(By.id("loginpassword")).sendKeys(fl.getDataFromProperties("password"));
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		cu.resolveStaleElement(driver.findElement(By.id("nameofuser")));
		System.out.println(driver.findElement(By.id("nameofuser")).getText());
		Assert.assertTrue(driver.findElement(By.id("nameofuser")).getText().contains(fl.getDataFromProperties("username")));
		Reporter.log("Logged in to the app", true);
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void configAM() {
		driver.findElement(By.id("logout2")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Log in")).isDisplayed());
		Reporter.log("Logged out from the app", true);
		test.pass("Logged out from the app");
	}
		
	@AfterTest(groups = {"smoke","regression"})
	public void configAS() {
		driver.quit();
		Reporter.log("Closed the browser", true);
		test.pass("Closed the browser");
		report.flush();
	}
	
}
