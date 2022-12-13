package com.testsripts.demoblaze;


import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.demoblaze.Base;
import com.genericlib.demoblaze.EventList;
import com.objectrepo.demoblaze.Homepage;
@Listeners(EventList.class)
public class DeleteProductFromCart extends Base {

	@Test(groups = {"regression"})
	public void deleteProductFromCartTest() throws InterruptedException, IOException {
		Homepage hp=PageFactory.initElements(driver, Homepage.class);
		test=report.createTest("Validate deletion of a product from the cart");
		test.pass("Logged into the app as "+fl.getDataFromProperties("username"));
		test.pass("Landed on Homepage");
		hp.getCart().click();
		test.pass("Clicked on cart");
		test.pass("Landed on the cart");
		cu.deleteProduct(driver, ProductName).click();
		test.pass("Clicked on delete buttonof the product");
		Thread.sleep(2000);
		try {
			cu.verifyProductInCart(ProductName, driver);
			Assert.assertTrue(false, "Product has not been deleted - Test failed");
		}
		catch(NoSuchElementException n){
			Reporter.log("Deleted"+ProductName+" from cart");
		}
		test.pass("Product deltetion has been verified");
		
	}
}
