package com.webshop.tests;

import org.testng.annotations.Test;

import com.webshop.pages.ApparelShoesPage;
import com.webshop.utils.Helper;

public class ApparelShoes extends BaseTest{
	
	
	@Test
	public void AddandDeleteproductsfromCart() 
	{
		logger = report.createTest("Validate default Values for Drop Down in Apparel-Shoes page");
		hp.clickapparelshoesmenulink();
		logger.pass("Clicked Apparel Shoes menu link");
		logger.pass("Page title is :"+" - "+Ap.gettitle());
		logger.pass("Page text is :"+" - "+Ap.getpagetext());
		logger.pass("Sort by dropdown default value is :"+" - "+Ap.sortbydefault());
		logger.pass("Display dropdown default value is :"+" - "+Ap.Displaydropdown());
		Ap.Displayvalue("12");
		logger.pass("Selected Display dropdown value as 12");
		logger.pass("Validate product grid displayed"+" - "+Ap.isproductgriddisplayed());
		logger.pass("Product Item Box Count :"+" - "+Ap.getproductitemboxcount());
		logger.pass("Clicking Add To Cart button for Jeans to Add Product");
		Ap.addtocart();
		logger.pass("Validate Message that Product has been added to cart :"+" - "+Ap.addedtocarttext());
		logger.pass("Clicking Add To Cart button for Belt to Add Product");
		Ap.Beltaddtocart();
		logger.pass("Validate Message that Product has been added to cart :"+" - "+Ap.addedtocarttext());
		Helper.sleep();
		logger.pass("Validate Cart qty :"+" - "+Ap.CartQty());
		logger.pass("Clicking Shopping Cart link to Display added products");
		hp.clickshoppingcartlink();
		logger.pass("Deleting products from Shopping Cart");
		Ap.DeleteJeans();
		Ap.DeleteBelt();
		logger.pass("Click Update Shopping Cart button");
		Ap.updatecart();
		logger.pass("Validate Shopping Cart Updated and shows Qty as (0)"+" - "+Ap.CartQty());
		logger.pass("Validate Empty shopping Cart Message Displayed :"+" - "+Ap.emptycartmsg());
		
	}

}
