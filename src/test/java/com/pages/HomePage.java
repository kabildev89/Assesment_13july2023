package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.inject.Inject;
import com.helpers.Utils;

public class HomePage {
	private WebDriver webDriver;

	By Home_Img = By.id("gh-la");
	By Search_Item = By.xpath("//input[@id='gh-ac']");
	By Search_icon = By.xpath("//input[@id='gh-btn']");

	@Inject
	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebElement getWebElement(final By elementPath) {
		if (!webDriver.findElements(elementPath).isEmpty())
			return webDriver.findElement(elementPath);
		else
			return null;
	}

	public List<WebElement> getWebElements(final By elementPath) {
		if (!webDriver.findElements(elementPath).isEmpty())
			return webDriver.findElements(elementPath);
		else
			return null;
	}

	public void launch_URL(String URL) throws Exception {
		webDriver.get(URL);
		WebElement Homeimg = getWebElement(Home_Img);
		if (Homeimg.isDisplayed()) {
			System.out.println("Home page displayed");
		}

	}

	public void searchItem(String itemname) {
		Utils.wait(2000);
		WebElement searchField = getWebElement(Search_Item);
		searchField.sendKeys(itemname);
		WebElement searchButton = getWebElement(Search_icon);
		searchButton.click();
		System.out.println("item is searched");
	}

}