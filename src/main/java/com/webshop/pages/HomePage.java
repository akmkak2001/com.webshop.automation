package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.driver.DriverScript;

public class HomePage extends DriverScript{
	
	//**************************** Page Elements/Locators ******************
	
	@FindBy(linkText = "Log in") WebElement loginlink;
	@FindBy(linkText = "Register") WebElement Registerlink;
	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(@href, '/apparel-shoes')]") WebElement Apparelshoesmenu;
	@FindBy(xpath = "//span[text()='Shopping cart']") WebElement ShoppingCartlink;
	
	
	//**************************** Page Initialization *********************
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//**************************** Page Actions/Methods ********************
	
	public String HomePageTitle()
	{
		return driver.getTitle();
	}

	public void clickloginlink()
	{
		loginlink.click();
	}
	
	public void clickregisterlink()
	{
		Registerlink.click();
	}
	
	public void clickapparelshoesmenulink()
	{
		Apparelshoesmenu.click();
	}
	
	public void clickshoppingcartlink()
	{
		ShoppingCartlink.click();
	}
}
