package org.stepdefinition;

import org.helper.HelperClass;
import org.openqa.selenium.WebElement;
import org.pojo.AddToCart;
import org.pojo.SearchProduct;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends HelperClass {
	
	@Given("amazone page")
	public void amazone_page() {
		openChromeBrowser();
		launchUrl("https://www.amazon.in/");
	   	}

	@Given("maximize the product")
	public void maximize_the_product() {
		maxWindow();
	 }

	@When("search the product")
	public void search_the_product() {
		SearchProduct k = new SearchProduct();
		WebElement searchProduct = k.getSearchProduct();
		fillTextBox(searchProduct, "iphones X");
	}

	@When("click the searched product")
	public void click_the_searched_product() {
		SearchProduct k = new SearchProduct();
		WebElement searchSubmit = k.getSearchSubmit();
		toClickButton(searchSubmit);
		
		WebElement clickProduct = k.getClickProduct();
		toClickButton(clickProduct);
		
		
		}

	@When("click add to cart")
	public void click_add_to_cart() throws InterruptedException {
		 AddToCart s = new AddToCart();
	     getAllWindowId();
		 pauseExecution(5000);
		 WebElement clickAddToCart = s.getClickAddToCart();
		 toClickButton(clickAddToCart);
		}

	@When("proceed for payment")
	public void proceed_for_payment() {
		AddToCart s = new AddToCart();
		WebElement preceedToCheckout = s.getPreceedToCheckout();
		jsClick(preceedToCheckout);
		
	}

	@Then("need to be in signin page")
	public void need_to_be_in_signin_page() throws InterruptedException {
		AddToCart s = new AddToCart();
		pauseExecution(8000);
        WebElement signInPage = s.getSignInPage();
        toGetAttribute(signInPage);
		
	   	}
	   
}
