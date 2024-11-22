package com.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webshop.utils.Helper;

public class LoginPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void loginpagetitle() 
	{
		logger = report.createTest("Validate Home Page & Login Page Title");
		String HomePageTitle = hp.HomePageTitle();
		logger.pass("Getting home page Title"+" - "+HomePageTitle);
		Assert.assertTrue(HomePageTitle.contains("Demo Web Shop"));;
		hp.clickloginlink();
		logger.pass("Clicked on login link");
		String title = lp.loginPageTitle();
		logger.pass("Get the login page Title");
		System.out.println("Login Page Title is : "+" - "+title);
		Assert.assertTrue(title.contains("Login"));
		logger.pass("Expected Title matches Actual Title");
	}
	
	@Test(priority = 4)
	public void testloginFunction() 
	{
		
		logger = report.createTest("Validate user is able to login Successfully");
		hp.clickloginlink();
		logger.pass("Clicked on login link");
		lp.enterEmailId("selauto1@test.com");
		logger.pass("Entered Valid Email");
		lp.enterPassword("Pass@123");
		logger.pass("Entered Valid Password");
		lp.clickloginbutton();
		logger.pass("Clicked login Button");
		String title = lp.loginPageTitle();
		logger.pass("Get Login Page Title");
		System.out.println("Login Page Title is :"+title);
		Assert.assertTrue(title.contains("Demo Web Shop"));
		logger.pass("Expected Title matches Actual Title");
		boolean logoutlink = lp.logoutlink();
		logger.pass("Is Logout link present :"+" - "+logoutlink);
	}
	
	@Test(priority = 2)
	public void InvalidEmail() 
	{
		logger = report.createTest("Validate error message for Invalid Email");
		hp.clickloginlink();
		logger.pass("Clicked on login link");
		lp.enterEmailId("selenium");
		logger.pass("Entered Invalid Email");
		lp.clickloginbutton();
		logger.pass("Clicked on login button");
		String errortext = lp.getemailerrortext();
		logger.pass("Get Invalid Email Error Text");
		System.out.println(errortext);
	}
	
	@Test(priority = 3)
	public void InvalidPwd() 
	{
		
		logger = report.createTest("Validate error message for Invalid Password");
		hp.clickloginlink();
		logger.pass("Clicked on login link");
		lp.enterEmailId("selauto1@test.com");
		logger.pass("Entered Valid Email");
		logger.pass("No Password Entered - Field left Blank");
		lp.clickloginbutton();
		logger.pass("Clicked on login button");
		String errortext = lp.getpwderrortext();
		logger.pass("Get Invalid Password Error Text"+":"+errortext);
		System.out.println(errortext);
	}
	
	
	@Test(dataProvider = "wsdata")
	public void multipleloginpwd(String username, String password) 
	{
		logger = report.createTest("Multiple Username and Password login test");
		hp.clickloginlink();
		logger.pass("Clicked on login link");
		lp.enterEmailId(username);
		logger.pass("Entered Username");
		lp.enterPassword(password);
		logger.pass("Entered Password");
		lp.clickloginbutton();
		logger.pass("Clicked on login button");
		Helper.sleep();
		
	}
	
}
