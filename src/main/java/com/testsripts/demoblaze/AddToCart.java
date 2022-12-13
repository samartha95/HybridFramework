package com.testsripts.demoblaze;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.demoblaze.Base;
import com.genericlib.demoblaze.EventList;
import com.objectrepo.demoblaze.Homepage;
@Listeners(EventList.class)
public class AddToCart extends Base{

	@Test(groups = {"smoke"})
	public void addToCartTest() throws IOException {
		test=report.createTest("Validate product can be added to cart");
		test.pass("Logged into the app as "+fl.getDataFromProperties("username"));
		Homepage hp=PageFactory.initElements(driver, Homepage.class);
		test.pass("Landed on Homepage");
		ProductName=hp.getNexus6().getText();
		hp.getNexus6().click();
		test.pass("Clciked on Nexus6 product");
		test.pass("Navigated to product details page");
		hp.getAddToCart().click();
		test.pass("Clicked on Add to Cart button");
		cu.waitTillAlertToBeDisplayed(driver);
		cu.acceptAlert(driver);
		test.pass("Handled Alert");
		hp.getCart().click();
		AssertJUnit.assertTrue(cu.verifyProductInCart(ProductName, driver).isDisplayed());
		Reporter.log("Added to cart",true);
		test.pass("Verified the product in the cart");
	}
	
}
