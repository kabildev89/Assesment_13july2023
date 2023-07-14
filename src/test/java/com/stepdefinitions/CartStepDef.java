package com.stepdefinitions;

import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.helpers.Constants;
import com.helpers.Utils;
import com.hooks.Hooks;
import com.pages.CartPage;
import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDef {

	public WebDriver driver = Hooks.getDriver();
	HomePage homepage = new HomePage();
	CartPage cartpage = new CartPage();

	static String lowpriceItemInCart = null;

	@Given("^User launches the ecommerce application$")
	public void user_launches_the_ecommerce_application() {
		System.out.println("Launching the web application");
		driver.get(Constants.app_Url);
		Utils.wait(2000);
	}

	@Given("User add {string} items to the cart")
	public void user_add_items_to_the_cart(String noOfItems) {
		int itemcount = Integer.parseInt(noOfItems);
		homepage.addItemsToTheCart(itemcount);
		System.out.println(noOfItems+" items are added to the cart");
	}

	@When("^User views the cart$")
	public void user_views_the_cart() {
		homepage.viewCart();
		System.out.println("Cart page is displayed");
	}

	@Then("User verifies {string} items listed in the cart")
	public void user_verifies_items_listed_in_the_cart(String noOfItems) {
		int itemcount = Integer.parseInt(noOfItems);
		if (cartpage.verifyCartPageDisplayed()) {
			Assert.assertTrue("VerifyItemsInTheCart", cartpage.verifyItemsInTheCart(itemcount));
			System.out.println("Verified "+noOfItems+" items are added to the cart");
		} else {
			assertFalse("Cart Page not displayed", true);
		}
	}

	@When("^User search for lowest price item$")
	public void user_search_for_lowest_price_item() {
		lowpriceItemInCart = cartpage.getLowestPriceItem();
		System.out.println("The lowest price from the items list is "+lowpriceItemInCart);
	}

	@When("^User able to remove the lowest price item from the cart$")
	public void user_able_to_remove_the_lowest_price_item_from_the_cart() {
		Assert.assertTrue("Removal of low price item", cartpage.removeLowestPriceItemFromCart(lowpriceItemInCart));
		System.out.println("Item with lowest price is removed from the cart");
	}

}