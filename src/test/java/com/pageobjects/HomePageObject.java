package com.pageobjects;

import org.openqa.selenium.By;

public class HomePageObject{
	/*
	 * // private WebDriver webDriver;
	 * item("//h2[@class='woocommerce-loop-product__title']","XPATH");
	 * 
	 * 
	 * String locator = ""; String locatorType = ""; HomePageObject(String locator,
	 * String locatorType) { this.locator = locator; this.locatorType = locatorType;
	 * }
	 * 
	 * public String getLocator() { return locator; }
	 * 
	 * public String getLocatorType() { return locatorType; }
	 */

	 public By item = By.xpath("//h2[@class='woocommerce-loop-product__title']");
	 public By addToCart = By.xpath("//a[contains(text(),'Add to cart')]");
	 public By viewCart = By.xpath("//a[contains(@class,'added_to_cart')]");
	 
}