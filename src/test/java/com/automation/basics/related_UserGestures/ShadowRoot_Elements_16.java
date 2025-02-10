package com.automation.basics.related_UserGestures;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowRoot_Elements_16 {
    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("chrome://downloads/");

        //to handle shadow-root elements we just us type() method.
        page.locator("#searchInput").type("Java");



    }
}
