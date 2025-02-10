package com.automation.basics.related_Browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchChromeEdgeBrowsers_3 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        //to launch the chrome browser which downloaded in local system
        //Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Users\\280714\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe")));
        //to launch the chrome browser which downloaded in local system
        //Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe")));

        //easiest and simplest way
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.google.com");
        System.out.println(page.title());
        page.close();
        playwright.close();
    }
}
