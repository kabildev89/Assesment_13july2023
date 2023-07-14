package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helpers.Utils;
import com.hooks.Hooks;
import com.pageobjects.CartPageObject;

public class CartPage {
	CartPageObject cartPageObj = new CartPageObject();
	private WebDriver driver = Hooks.getDriver();

	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	public boolean verifyCartPageDisplayed() {
		boolean display = false;
		String title = driver.getTitle();
		if (title.contains("Cart")) {
			display = true;
		}
		return display;
	}

	public boolean verifyItemsInTheCart(int NoOfItems) {
		boolean verify = false;
		List<WebElement> items = driver.findElements(cartPageObj.itemrows);
		if (items.size() == NoOfItems) {
			verify = true;
		}
		return verify;
	}

	public String getLowestPriceItem() {
		String lowPrice = null;

		List<WebElement> itemprice = driver.findElements(cartPageObj.itemPrice);
		double lowPriceItem = Double.parseDouble(itemprice.get(0).getText().replace("$", ""));

		for (int i = 1; i < itemprice.size(); i++) {
			double current = Double.parseDouble(itemprice.get(i).getText().replace("$", ""));
			if (current < lowPriceItem) {
				lowPriceItem = current;
			}
		}
		lowPrice = String.valueOf(lowPriceItem);
		return lowPrice;
	}

	public boolean removeLowestPriceItemFromCart(String LowPrice) {
		boolean remove = false;
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageObj.itemrows));

		List<WebElement> items = driver.findElements(cartPageObj.itemrows);

		for (int i = 0; i < items.size(); i++) {
			if ((items.get(i).findElement(cartPageObj.itemPrice).getText()).contains(LowPrice)) {
				items.get(i).findElement(cartPageObj.removeIcon).click();
				Utils.wait(2000);
				remove = true;
				break;
			}
		}
		return remove;
	}
}
