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
import com.pageobjects.HomePageObject;

public class HomePage {
	HomePageObject homePageObj = new HomePageObject();
	private WebDriver driver = Hooks.getDriver();

	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public void addItemsToTheCart(int itemCount) {

		List<WebElement> items = driver.findElements(homePageObj.item);
		List<WebElement> addCartBtn = driver.findElements(homePageObj.addToCart);
		for (int i = 0; i < itemCount; i++) {
			action.moveToElement(items.get(i)).build().perform();
			Utils.wait(1000);
			addCartBtn.get(i).click();
			Utils.wait(1000);
		}

	}

	public void viewCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObj.viewCart));
		List<WebElement> viewCartBtn = driver.findElements(homePageObj.viewCart);
		viewCartBtn.get(3).click();
		Utils.wait(4000);
	}

}