package org.pojo;

import org.helper.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart extends HelperClass {
	
	public AddToCart() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//input[@id='add-to-cart-button']")
	private WebElement clickAddToCart;
	
	@FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[9]")
	private WebElement preceedToCheckout;
	

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout (3 items)')]")
	private WebElement signInPage;

	public WebElement getSignInPage() {
		return signInPage;
	}


	public WebElement getPreceedToCheckout() {
		return preceedToCheckout;
	}


	public WebElement getClickAddToCart() {
		return clickAddToCart;
	}

}
