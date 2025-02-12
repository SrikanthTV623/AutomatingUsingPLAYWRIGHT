package com.automation.basics.related_authentication;

import com.microsoft.playwright.*;

public class Handling_BasicAuth_22 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser
                .NewContextOptions()
                .setHttpCredentials("admin", "admin"));

        Page page = context.newPage();
        page.navigate("http://the-internet.herokuapp.com/basic_auth");
    }
}
