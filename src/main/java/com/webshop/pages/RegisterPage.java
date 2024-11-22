package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.driver.DriverScript;

public class RegisterPage extends DriverScript{
	
	//**************************** Page Elements/Locators ******************
	
			@FindBy(id = "gender-male") WebElement mgenderradiobutton;
			@FindBy(id = "gender-female") WebElement femgenderradiobutton;
			@FindBy(id = "FirstName") WebElement FirstNametextbox;
			@FindBy(id = "LastName") WebElement LastNametextbox;
			@FindBy(id = "Email") WebElement Emailtextbox;
			@FindBy(id = "Password") WebElement Passwordtextbox;
			@FindBy(id = "ConfirmPassword") WebElement ConfirmPasswordtextbox;
			@FindBy(id = "register-button") WebElement registerbutton;
			
			
			//**************************** Page Initialization *********************
			
			public RegisterPage()
			{
				PageFactory.initElements(driver, this);
			}
			
			
			//**************************** Page Actions/Methods ********************
			
			public void gendermradiobutton()
			{
				mgenderradiobutton.click();
			}
			
			public void genderfradiobutton()
			{
				femgenderradiobutton.click();
			}
			
			public void FirstName(String FName)
			{
				FirstNametextbox.sendKeys(FName);
				
			}
			
			public void LastName(String LName)
			{
				LastNametextbox.sendKeys(LName);
				
			}
			
			public void Email(String Email)
			{
				Emailtextbox.sendKeys(Email);
			}
			
			public void Password(String pwd)
			{
				Passwordtextbox.sendKeys(pwd);
			}
			
			public void ConfirmPassword(String Cpwd)
			{
				ConfirmPasswordtextbox.sendKeys(Cpwd);
			}

}
