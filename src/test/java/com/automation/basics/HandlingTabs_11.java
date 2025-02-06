package com.automation.basics;

import com.microsoft.playwright.*;

public class HandlingTabs_11 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");

        //to handle the multiple tabs
        //we provide the locator of that popup to waitforpopup listener
        Page popup = page.waitForPopup(() -> {
            page.locator("text=Privacy Policy").nth(0).click();
        });

        popup.locator("//*[@id=\"header-sign-up-btn\"]").click();
        popup.locator("#user_name").type("Rahul Arora");

        popup.close(); //to close second tab that is opened

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        page.close();
        browser.close();
        playwright.close();

    }
}
