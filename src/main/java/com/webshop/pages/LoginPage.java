package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.driver.DriverScript;

public class LoginPage extends DriverScript{
	
	//**************************** Page Elements/Locators ******************
	
		@FindBy(id = "Email") WebElement emailtextbox;
		@FindBy(name = "Password") WebElement Passwordtextbox;
		@FindBy(xpath = "//input[@value='Log in']") WebElement loginbutton;
		@FindBy(xpath = "//a[text()='Forgot password?']") WebElement forgotpasswordlink;
		@FindBy(xpath = "//span[text()='Please enter a valid email address.']") WebElement errortext;
		@FindBy(xpath = "//span[text()='Login was unsuccessful. Please correct the errors and try again.']") WebElement pwderrortext;
		@FindBy(xpath = "//span[contains(text(),'Login was unsuccessful.')]") WebElement pwderrortext1;
		@FindBy(xpath = "//a[@href='/logout']") WebElement logoutlink;
		
		//**************************** Page Initialization *********************
		
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		
		//**************************** Page Actions/Methods ********************
		
		public String loginPageTitle()
		{
			return driver.getTitle();
		}
		
		public boolean isforgotpassworddisplayed()
		{
			return forgotpasswordlink.isDisplayed();
		}
		
		public void enterEmailId(String email)
		{
			emailtextbox.sendKeys(email);
		}
		
		public void enterPassword(String pwd)
		{
			Passwordtextbox.sendKeys(pwd);
		}
		
		public void clickloginbutton()
		{
			loginbutton.click();
		}

		public String getemailerrortext()
		{
			return errortext.getText();
		}
		
		public String getpwderrortext()
		{
			return pwderrortext1.getText();
		}
		
		public boolean logoutlink()
		{
			return logoutlink.isDisplayed();
		}
}
