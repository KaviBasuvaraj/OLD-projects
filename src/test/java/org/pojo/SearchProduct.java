package org.pojo;

import org.helper.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct extends HelperClass{
	
	public SearchProduct() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchProduct;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement searchSubmit;
	
	@FindBy (xpath = "//span[contains(text(),'Apple iPhone 11 (64GB) - Black')]")
	private WebElement  clickProduct;
	

	public WebElement getSearchProduct() {
		return searchProduct;
	}

	public WebElement getSearchSubmit() {
		return searchSubmit;
	}

	public WebElement getClickProduct() {
		return clickProduct;
	}
	
	

}
