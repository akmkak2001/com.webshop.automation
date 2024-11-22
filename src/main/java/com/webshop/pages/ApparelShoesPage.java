package com.webshop.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.webshop.driver.DriverScript;

public class ApparelShoesPage extends DriverScript{
	
	//**************************** Page Elements/Locators ******************
	
			@FindBy(xpath = "//h1[text()='Apparel & Shoes']") WebElement pagetext;
			@FindBy(id = "products-orderby") WebElement sortbydropdown;
			@FindBy(id = "products-pagesize") WebElement Displaydropdown;
			@FindBy(xpath = "//div[@class='product-grid']") WebElement productgrid;
			@FindBy(xpath = "//div[@class='product-grid']//div[@class='item-box']") List<WebElement> productitembox;
			@FindBy(xpath = "//div[@class='product-grid']//div[3]//div[1]//div[2]//div[3]//div[2]//input[1]") WebElement JeansAddtocartbutton;
			@FindBy(xpath = "//div[@class='product-grid']//div[4]//div[1]//div[2]//div[3]//div[2]//input[1]") WebElement BeltAddtocartbutton;
			@FindBy(xpath = "//p[text()='The product has been added to your ']") WebElement AddedToCarttext; 
			@FindBy(xpath = "//span[@class='cart-qty']") WebElement CartQty;
			//@FindBy(xpath = "//span[@class='cart-qty' and contains(text(),'(2)')]") WebElement CartQty;
			@FindBy(xpath = "//tr[@class='cart-item-row']//td[@class='remove-from-cart']//input[@type='checkbox' and @name='removefromcart' and ancestor::tr/td[@class='product-picture']//img[@alt='Picture of Blue Jeans']]\n"
					+ "") WebElement JeansProduct;
			@FindBy(xpath = "//tr[@class='cart-item-row']//td[@class='remove-from-cart']//input[@type='checkbox' and @name='removefromcart' and ancestor::tr/td[@class='product-picture']//img[@alt='Picture of Casual Golf Belt']]\n"
					+ "") WebElement BeltProduct;
			@FindBy(xpath = "//input[@name='updatecart']") WebElement UpdateCart;
			@FindBy(xpath = "//div[contains(text(), 'Your Shopping Cart is empty')]") WebElement emptycartmessage;
			
			//**************************** Page Initialization *********************
			
			public ApparelShoesPage()
			{
				PageFactory.initElements(driver, this);
			}
			
			//**************************** Page Actions/Methods ********************
			
			public String gettitle()
			{
				return driver.getTitle();
			}
			
			public String getpagetext()
			{
				return pagetext.getText();
			}
			
			public String sortbydefault()
			{
				Select dropdown = new Select(sortbydropdown);
				return dropdown.getFirstSelectedOption().getText();
			}
			
			public void Displayvalue(String option)
			{
				Select value = new Select(Displaydropdown);
				value.selectByVisibleText(option);
			}
			
			public int Displaydropdown()
			{
				Select displaydropdown = new Select(Displaydropdown);
				String defaultvalue = displaydropdown.getFirstSelectedOption().getText();
				int defValue = Integer.parseInt(defaultvalue);
				return defValue;
			}
			
			public boolean isproductgriddisplayed()
			{
				return productgrid.isDisplayed();
			}
			
			public int getproductitemboxcount()
			{
				return productitembox.size();
			}
			
			public void addtocart()
			{
				JeansAddtocartbutton.click();
			}
			
			public void Beltaddtocart()
			{
				BeltAddtocartbutton.click();
			}
			
			public String addedtocarttext()
			{
				return AddedToCarttext.getText();
			}
			
			public String CartQty()
			{
				return CartQty.getText();
			}
			
			/*public int CartQty()
			{
				String text = CartQty.getText();
				int value = Integer.parseInt(text.trim());
				return value;
			}*/
			
			public void DeleteJeans()
			{
				JeansProduct.click();
			}
			
			public void DeleteBelt()
			{
				BeltProduct.click();
			}
			
			public void updatecart()
			{
				UpdateCart.click();
			}
			
			public String emptycartmsg()
			{
				return emptycartmessage.getText();
			}
			
			

}
