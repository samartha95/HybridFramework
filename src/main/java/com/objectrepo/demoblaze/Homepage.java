package com.objectrepo.demoblaze;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	
	
	@FindBy(linkText = "Log in")
	private WebElement Login;
	
	@FindBy(id = "loginusername")
	private WebElement LoginUsername;
	
	@FindBy(id = "loginpassword")
	private WebElement LoginPassword;
	
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement LoginLoginButton;
	
	@FindBy(id = "nameofuser")
	private WebElement NameOfUser;
	
	@FindBy(id = "logout2")
	private WebElement Logout;
	
	@FindBy(xpath = "//a[text()='Nexus 6']")
	private WebElement Nexus6;
	
	@FindBy(xpath = "//a[text()='Add to cart']")
	private WebElement AddToCart;
	
	@FindBy(xpath = "//a[text()='Cart']")
	private WebElement Cart;
	
	
	
	//Getters

	public WebElement getLogin() {
		return Login;
	}

	public WebElement getCart() {
		return Cart;
	}

	public WebElement getNexus6() {
		return Nexus6;
	}

	public WebElement getAddToCart() {
		return AddToCart;
	}


	public WebElement getLogout() {
		return Logout;
	}

	public WebElement getLoginUsername() {
		return LoginUsername;
	}

	public WebElement getLoginPassword() {
		return LoginPassword;
	}

	public WebElement getLoginLoginButton() {
		return LoginLoginButton;
	}

	public WebElement getNameOfUser() {
		return NameOfUser;
	}
	

	
	
}
