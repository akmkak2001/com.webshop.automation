package com.webshop.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.webshop.driver.DriverScript;
import com.webshop.pages.ApparelShoesPage;
import com.webshop.pages.HomePage;
import com.webshop.pages.LoginPage;
import com.webshop.pages.RegisterPage;
import com.webshop.utils.ExcelUtil;
import com.webshop.utils.Helper;

public class BaseTest extends DriverScript{
	
	protected static ExtentHtmlReporter extent;
	protected static ExtentReports report;
	protected static ExtentTest logger;
	
	HomePage hp;
	LoginPage lp;
	ApparelShoesPage Ap;
	RegisterPage reg;
	
	@BeforeSuite
	public void setupReports()
	{
		extent = new ExtentHtmlReporter("./reports/index.html");
		report = new ExtentReports();
		report.attachReporter(extent);
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initApplication();
		hp = new HomePage();
		lp = new LoginPage();
		reg = new RegisterPage();
		Ap = new ApparelShoesPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		Helper.sleep();
		quitDriver();
		report.flush();
	}
	
	@DataProvider(name="wsdata")
	public Object[][] testdata() throws IOException
	{
		String filepath = "./src/test/resources/testdata/wsdata.xlsx";
		int rcount = ExcelUtil.getRowCount(filepath,"sheet0");
		System.out.println("row count :"+rcount);
		
		Object[][] data = new Object[rcount][2];
		
		for(int i=0;i<rcount;i++)
		{
			data[i][0] = ExcelUtil.getCellData(filepath, "sheet0", i, 0);
			data[i][1] = ExcelUtil.getCellData(filepath, "sheet0", i, 1);
			//data[i][1] = ExcelUtil.getCellData(filepath, "sheet0", i, 1);
		}
		
		return data;
	}

}
