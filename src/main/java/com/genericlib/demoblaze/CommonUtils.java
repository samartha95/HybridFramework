package com.genericlib.demoblaze;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	
	
	public WebElement verifyProductInCart(String pn,WebDriver driver) {
		return driver.findElement(By.xpath("//td[text()='"+pn+"']"));
	}
	
	public WebElement deleteProduct(WebDriver driver,String pn) {
		return driver.findElement(By.xpath("//td[text()='"+pn+"']/following-sibling::td/a"));
	}
	
	public void acceptAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	
	public void waitTillElementToBeClickable(WebDriver driver,WebElement e) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public void waitTillAlertToBeDisplayed(WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	} 
	
	public void resolveStaleElement(WebElement w) throws InterruptedException {
		for(int i=0;i<3;i++) {
			try {
				Thread.sleep(2000);
				w.getText();
				break;
			}
			catch(StaleElementReferenceException e) {

			}
		}
	}
}
