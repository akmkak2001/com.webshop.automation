package com.webshop.tests;

import org.testng.annotations.Test;

import com.webshop.driver.DriverScript;
import com.webshop.pages.HomePage;
import com.webshop.pages.RegisterPage;

public class RegisterPageTest extends BaseTest{
	

	@Test
	public void Registration() 
	{
		hp.clickregisterlink();
		reg.gendermradiobutton();
		reg.genderfradiobutton();
		reg.FirstName("John");
		reg.LastName("Doe");
		reg.Email("Selenium@test.org");
		reg.Password("testing");
		reg.ConfirmPassword("testing");
		
	}

}
