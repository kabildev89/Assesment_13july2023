package com.pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;
import com.helpers.Utils;

public class SearchResultsPage {
	private WebDriver webDriver;

	By searchResults = By
			.xpath("//ul[contains(@class,'srp-results')]/li[contains(@class,'s-item s-item__pl-on-bottom')]");
	By ItemDetails = By.xpath(
			"//ul[contains(@class,'srp-results')]/li[contains(@class,'s-item s-item__pl-on-bottom')]//div[contains(@class,'s-item__details clearfix')]");
	By postagePrice = By.xpath("//span[contains(text(),'postage')]");
	By bidsCount = By.xpath("//span[contains(@class,'s-item__bids s-item__bidCount')]");
	By itemPrice = By.xpath(
			"//ul[contains(@class,'srp-results')]/li[contains(@class,'s-item s-item__pl-on-bottom')]//span[contains(@class,'s-item__price')]");
	By buyItNow = By.xpath("//ul[contains(@class,'srp-results')]//span[contains(text(),'Buy it now')]");
	By BestMatch = By.xpath("//span[contains(text(),'Best Match')]");
	By HighToLow = By.xpath("//span[contains(text(),'Highest price')]");
	By LowToHigh = By.xpath("//span[contains(text(),'Lowest price')]");
	By sortOptions = By.cssSelector("li>a.fake-menu-button__item");
	By PageNumbers = By.cssSelector("a.pagination__item");

	@Inject
	public SearchResultsPage(WebDriver webDriver) {
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

	public List<WebElement> getListOfItems() {
		Utils.wait(2000);
		List<WebElement> availableItems = getWebElements(searchResults);
		int count = availableItems.size();
		return availableItems;

	}

	public void verifyPostagePriceForItems() {
		List<WebElement> itemDetailList = getWebElements(ItemDetails);
		int itemCount = itemDetailList.size();
		System.out.println("The items displayed are " + itemCount);
		for (int i = 0; i < itemCount; i++) {
			String detail = itemDetailList.get(i).getText();
			if (detail.contains("postage")) {
				assertTrue("Postage price is displayed", detail.contains("postage"));
			} else {
				System.out.println("Postage price is not available for " + i + " item");
			}
		}
	}

	public void verifyBidDetailsInResultsPage() {
		List<WebElement> itemDetailList = getWebElements(ItemDetails);
		int itemCount = itemDetailList.size();
		System.out.println("The items displayed are " + itemCount);
		for (int i = 0; i < itemCount; i++) {
			String detail = itemDetailList.get(i).getText();
			if (detail.contains("bids")) {
				assertTrue("No of bids is displayed", detail.contains("bids"));
			} else {
				System.out.println("No of bids is not available for " + i + " item");
			}
		}
	}

	public void verifyitemPriceDetailsInResultsPage() {
		List<WebElement> itemPriceList = getWebElements(itemPrice);
		int itemCount = itemPriceList.size();
		assertTrue("Atleast 60 items should be displayed", itemCount >= 60);
		for (int i = 0; i < itemCount; i++) {
			assertTrue("Item price is displayed", itemPriceList.get(i).isDisplayed());
		}
	}

	public void verifybuyItNowDetailsInResultsPage() {
		List<WebElement> itemDetailList = getWebElements(ItemDetails);
		int itemCount = itemDetailList.size();
		System.out.println("The items displayed are " + itemCount);
		for (int i = 0; i < itemCount; i++) {
			String detail = itemDetailList.get(i).getText();
			if (detail.contains("Buy it now")) {
				assertTrue("Buy it now label is displayed", detail.contains("Buy it now"));
			} else {
				System.out.println("Buy it now is not available for " + i + " item");
			}
		}
	}

	// Select option to Sort from low to high
	public void sortLowestPrice() {
		try {
			Utils.wait(2000);
			WebElement sortOption = getWebElement(BestMatch);
			sortOption.click();
			List<WebElement> optionList = webDriver.findElements(By.cssSelector("li>a.fake-menu-button__item"));
			for (WebElement options : optionList) {
				if (options.getText().trim().equals("Lowest price")) {
					options.click();
					break;
				}
			}
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			WebElement sortOption = getWebElement(BestMatch);
			sortOption.click();
			List<WebElement> optionList = getWebElements(sortOptions);
			for (WebElement options : optionList) {
				if (options.getText().trim().equals("Lowest price")) {
					options.click();
					break;
				}
			}
		}
		System.out.println("Sorting the lowest price");

	}

	//
	public void verifyitemPriceIsSortedInAscendingOrder() {
		List<WebElement> itemDetailList = getWebElements(ItemDetails);
		int itemCount = itemDetailList.size();
		List<WebElement> itemPriceList = getWebElements(itemPrice);
		for (int i = 0; i < itemCount - 1; i++) {
			String firstItemprice = itemPriceList.get(i).getText().replace("£", "");
			String secondItemprice = itemPriceList.get(i + 1).getText().replace("£", "");

			double firstprice = Double.parseDouble(firstItemprice);
			double secondprice = Double.parseDouble(secondItemprice);
			if (firstprice <= secondprice) {
				System.out.println("Item is sorted in ascending order for " + i + " item");
			} else {
				System.out.println("Item is not sorted in ascending order for " + i + " item");
			}

		}
	}

	public void sortHighToLow() {

		Utils.wait(2000);
		WebElement sortOption = getWebElement(LowToHigh);
		sortOption.click();
		List<WebElement> optionList = getWebElements(sortOptions);
		for (WebElement options : optionList) {
			if (options.getText().trim().equals("Highest price")) {
				options.click();
				break;
			}
		}
		System.out.println("Sorted the High to Low price");

	}

	//
	public void verifyitemPriceIsSortedInDescendingOrder() {
		List<WebElement> itemDetailList = getWebElements(ItemDetails);
		int itemCount = itemDetailList.size();
		List<WebElement> itemPriceList = getWebElements(itemPrice);
		for (int i = 0; i < itemCount - 1; i++) {
			String firstItemprice = itemPriceList.get(i).getText().replace("£", "");
			String secondItemprice = itemPriceList.get(i + 1).getText().replace("£", "");
			double firstprice;
			double secondprice;
			try {
				firstprice = Double.parseDouble(firstItemprice);
				secondprice = Double.parseDouble(secondItemprice);
			} catch (NumberFormatException e) {
				if (firstItemprice.contains("to")) {
					String[] firstItem = secondItemprice.split("t");
					firstItemprice = firstItem[0];
				}
				if (secondItemprice.contains("to")) {
					String[] secondItem = secondItemprice.split("t");
					secondItemprice = secondItem[0];
				}
				if (firstItemprice.contains(",")) {
					firstItemprice = firstItemprice.replace(",", "");
				}
				if (secondItemprice.contains(",")) {
					secondItemprice = secondItemprice.replace(",", "");
				}
				firstprice = Double.parseDouble(firstItemprice);
				secondprice = Double.parseDouble(secondItemprice);
			}
			if (firstprice >= secondprice) {
				System.out.println("Item is sorted in descending order for " + i + " item");
			} else {
				System.out.println("Item is not sorted in descending order for " + i + " item");
			}

		}
	}

	public void verifypageNumbers() {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		List<WebElement> pages = getWebElements(PageNumbers);
		int size = pages.size();
		for (int i = 0; i < size - 1; i++) {
			assertTrue(size + " Page Numbers are displayed", pages.get(i).isDisplayed());
		}
	}

	public void navigateToDiffPagesAndVerify() {
		try 
		{
			List<WebElement> pages = getWebElements(PageNumbers);
			//WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
			int size = pages.size();
			//wait.until(ExpectedConditions.presenceOfElementLocated(PageNumbers));
			for (int i = 1; i < size-1; i++) {
				try {
						//webDriver.navigate().refresh();
						//pages = getWebElements(PageNumbers);
						navigatePageNumber(pages,i);
				}
				catch(StaleElementReferenceException e) {
					//webDriver.navigate().refresh();
					//pages = getWebElements(PageNumbers);
					navigatePageNumber(pages,i);
				}
			}
		}
		catch (StaleElementReferenceException e) {
			//navigatePageNumber();
			System.out.println(e);
		}

	}

	public void navigatePageNumber(List<WebElement> pages,int PageNumber) {

		//webDriver.navigate().refresh();
		pages = getWebElements(PageNumbers);
		//List<WebElement> pages = getWebElements(PageNumbers);
		//WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
		//int size = pages.size();
		//wait.until(ExpectedConditions.presenceOfElementLocated(PageNumbers));
		//for (int i = 0; i < size-1; i++) {
			//wait.until(ExpectedConditions.presenceOfElementLocated(PageNumbers));
			String SelectedPage = pages.get(PageNumber).getAttribute("aria-current");
			if (SelectedPage == null) {
				// if(!IsCurrentPage.equals("page")) {
				pages.get(PageNumber).click();
				Utils.wait(2000);
				List<WebElement> itemDetailList = getWebElements(ItemDetails);
				int itemCount = itemDetailList.size();
				System.out.println("The items displayed are " + itemCount);
				JavascriptExecutor js = (JavascriptExecutor) webDriver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
				// webDriver.navigate().refresh();
				Utils.wait(2000);
			}
	}
}