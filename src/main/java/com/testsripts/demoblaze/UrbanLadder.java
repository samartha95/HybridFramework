package com.testsripts.demoblaze;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UrbanLadder {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.urbanladder.com/");
		Actions act=new Actions(driver);
		List<WebElement> mm = driver.findElements(By.xpath("//ul[@class='topnav bodytext']/li"));
		for (int i = 0; i < mm.size(); i++) {
			String MainMenu=mm.get(i).getText();
			System.out.println(MainMenu+" ==>");
			act.moveToElement(mm.get(i)).perform();
			Thread.sleep(1000);
			List<WebElement> sm = driver.findElements(By.xpath("//span[contains(text(),'"+MainMenu+"')]/parent::li/descendant::div/a"));
			for (int j = 0; j <sm.size(); j++) {
				String SecondLevel=sm.get(j).getText();
				System.out.println(SecondLevel+" =>");
				Thread.sleep(1000);
				List<WebElement> si = driver.findElements(By.xpath("//span[contains(text(),'"+MainMenu+"')]/parent::li/descendant::div/a[contains(text(),'"+SecondLevel+"')]/parent::div/following-sibling::ul/descendant::span"));
				for (int k = 0; k < si.size(); k++) {
					System.out.println(si.get(k).getText());
				}
			
			}
		}
		driver.quit();
	}

}
