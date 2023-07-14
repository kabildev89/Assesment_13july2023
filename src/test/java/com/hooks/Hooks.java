package com.hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.helpers.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	public static WebDriver webDriver;

	@SuppressWarnings("deprecation")
	@Before("@cart")
	public void setUp() throws InterruptedException {
		System.out.println("Browser is launching...");
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		Utils.wait(5000);
	}

	@After("@cart")
	public void closeBrowser() {
		System.out.println("Closing the Browser");
		//webDriver.close();
		webDriver.quit();
	}

	public static WebDriver getDriver() {
		return webDriver;
	}
}