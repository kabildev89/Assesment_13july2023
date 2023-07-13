$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("LendInvest.feature");
formatter.feature({
  "line": 2,
  "name": "To automate the ebay site",
  "description": "This feature is to do test Automation on ebay website",
  "id": "to-automate-the-ebay-site",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@EbayFeature"
    }
  ]
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Search and verify the items in ebay website",
  "description": "",
  "id": "to-automate-the-ebay-site;search-and-verify-the-items-in-ebay-website",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@ebay"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User launch the ebay application",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I search for an item \"\u003citemname\u003e\" as a non-registered customer",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I get a list of matching results",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "the resulting items cards show: postage price, No of bids, price or show BuyItNow tag",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I sort the results by Lowest Price",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "the results are listed in the page in the ascending order",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I sort the results by Highest Price",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "the results are listed in the page in the descending order",
  "keyword": "Then "
});
formatter.examples({
  "line": 16,
  "name": "",
  "description": "",
  "id": "to-automate-the-ebay-site;search-and-verify-the-items-in-ebay-website;",
  "rows": [
    {
      "cells": [
        "itemname"
      ],
      "line": 17,
      "id": "to-automate-the-ebay-site;search-and-verify-the-items-in-ebay-website;;1"
    },
    {
      "cells": [
        "speaker"
      ],
      "line": 18,
      "id": "to-automate-the-ebay-site;search-and-verify-the-items-in-ebay-website;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3669058700,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Search and verify the items in ebay website",
  "description": "",
  "id": "to-automate-the-ebay-site;search-and-verify-the-items-in-ebay-website;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@ebay"
    },
    {
      "line": 1,
      "name": "@EbayFeature"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User launch the ebay application",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I search for an item \"speaker\" as a non-registered customer",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I get a list of matching results",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "the resulting items cards show: postage price, No of bids, price or show BuyItNow tag",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I sort the results by Lowest Price",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "the results are listed in the page in the ascending order",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I sort the results by Highest Price",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "the results are listed in the page in the descending order",
  "keyword": "Then "
});
formatter.match({
  "location": "LendInvestStepDef.user_launch_the_ebay_application()"
});
formatter.result({
  "duration": 2950862100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "speaker",
      "offset": 22
    }
  ],
  "location": "LendInvestStepDef.i_search_for_an_item_as_a_non_registered_customer(String)"
});
formatter.result({
  "duration": 2019132800,
  "error_message": "org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d108.0.5359.125)\nBuild info: version: \u00274.1.1\u0027, revision: \u0027e8fcc2cecf\u0027\nSystem info: host: \u0027YUVINKABILDEV\u0027, ip: \u0027192.168.1.218\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_161\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCommand: [4ba83cc0de1a33626b95428397ae69c3, findElements {using\u003dxpath, value\u003d//input[@id\u003d\u0027gh-ac\u0027]}]\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 108.0.5359.125, chrome: {chromedriverVersion: 108.0.5359.71 (1e0e3868ee06..., userDataDir: C:\\Users\\KUMARA~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:50163}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), se:cdp: ws://localhost:50163/devtoo..., se:cdpVersion: 108.0.5359.125, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: 4ba83cc0de1a33626b95428397ae69c3\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:200)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:133)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:53)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:184)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.invokeExecute(DriverCommandExecutor.java:167)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:142)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:543)\r\n\tat org.openqa.selenium.remote.ElementLocation$ElementFinder$2.findElements(ElementLocation.java:179)\r\n\tat org.openqa.selenium.remote.ElementLocation.findElements(ElementLocation.java:102)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:382)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:374)\r\n\tat com.ebay.pages.HomePage.getWebElement(HomePage.java:26)\r\n\tat com.ebay.pages.HomePage.searchItem(HomePage.java:50)\r\n\tat com.ebay.stepdefinitions.LendInvestStepDef.i_search_for_an_item_as_a_non_registered_customer(LendInvestStepDef.java:33)\r\n\tat ✽.When I search for an item \"speaker\" as a non-registered customer(LendInvest.feature:8)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LendInvestStepDef.i_get_a_list_of_matching_results()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LendInvestStepDef.the_resulting_items_cards_show_postage_price_No_of_bids_price_or_show_BuyItNow_tag()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LendInvestStepDef.i_sort_the_results_by_Lowest_Price()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LendInvestStepDef.the_results_are_listed_in_the_page_in_the_ascending_order()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LendInvestStepDef.i_sort_the_results_by_Highest_Price()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LendInvestStepDef.the_results_are_listed_in_the_page_in_the_descending_order()"
});
formatter.result({
  "status": "skipped"
});
