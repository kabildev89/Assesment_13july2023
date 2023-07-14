package com.pageobjects;

import org.openqa.selenium.By;

public class CartPageObject {
	 public By itemrows = By.xpath("//tr[contains(@class,'woocommerce-cart-form__cart-item')]");
	 public By itemPrice = By.cssSelector(".product-price>span");
	 public By removeIcon = By.cssSelector(".product-remove>a");
	
	}
