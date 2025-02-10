package com.automation.basics.related_Browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBroswer_1 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://playwright.dev");
        System.out.println(page.title());
    }
}
