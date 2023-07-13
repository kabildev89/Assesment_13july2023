package com.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.helpers.Constants;
import com.hooks.Hooks;
import com.pages.HomePage;
import com.pages.SearchResultsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDef {

	WebDriver driver = Hooks.getDriver();
	HomePage homepage = new HomePage(driver);
	
	SearchResultsPage searchresultsPage = new SearchResultsPage(driver);
	static List<WebElement> itemList = null;

	@Given("^User launch the ebay application$")
	public void user_launch_the_ebay_application() throws Throwable {
		String url = Constants.app_Url;
		homepage.launch_URL(url);

	}

	@When("^I search for an item \"([^\"]*)\" as a non-registered customer$")
	public void i_search_for_an_item_as_a_non_registered_customer(String item) throws Throwable {
		homepage.searchItem(item);
	}

	@Then("^I get a list of matching results$")
	public void i_get_a_list_of_matching_results() throws Throwable {
		itemList = searchresultsPage.getListOfItems();

	}

	@Then("^the resulting items cards show: postage price, No of bids, price or show BuyItNow tag$")
	public void the_resulting_items_cards_show_postage_price_No_of_bids_price_or_show_BuyItNow_tag() throws Throwable {
		searchresultsPage.verifyPostagePriceForItems();
		searchresultsPage.verifyBidDetailsInResultsPage();
		searchresultsPage.verifyitemPriceDetailsInResultsPage();
		searchresultsPage.verifybuyItNowDetailsInResultsPage();
	}

	@When("^I sort the results by Lowest Price$")
	public void i_sort_the_results_by_Lowest_Price() throws Throwable {
		searchresultsPage.sortLowestPrice();
	}

	@Then("^the results are listed in the page in the ascending order$")
	public void the_results_are_listed_in_the_page_in_the_ascending_order() throws Throwable {
		searchresultsPage.verifyitemPriceIsSortedInAscendingOrder();
	}

	@When("^I sort the results by Highest Price$")
	public void i_sort_the_results_by_Highest_Price() throws Throwable {
		searchresultsPage.sortHighToLow();
	}

	@Then("^the results are listed in the page in the descending order$")
	public void the_results_are_listed_in_the_page_in_the_descending_order() throws Throwable {
		searchresultsPage.verifyitemPriceIsSortedInDescendingOrder();
	}
	
	@Then("^The results show more than one page$")
	public void the_results_show_more_than_one_page() throws Throwable {
		searchresultsPage.verifypageNumbers();
	}

	@Then("^The user can navigate through the pages to continue looking at the items$")
	public void the_user_can_navigate_through_the_pages_to_continue_looking_at_the_items() throws Throwable {
		searchresultsPage.navigateToDiffPagesAndVerify();
	}

}