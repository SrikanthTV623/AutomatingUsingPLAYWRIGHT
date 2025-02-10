package com.automation.basics.related_iframes;

import com.microsoft.playwright.*;

public class HandlingiFrames_10 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");

        page.frameLocator("[name='iframeResult']").locator("body > button").click(new Locator.ClickOptions().setTimeout(2000));

        Locator frames = page.locator("iframe");
        System.out.println(frames.count()); //count no of iframes present in the webpage

        //to print all iframes id's
        for (int i = 0; i < frames.count(); i++) {
            System.out.println(frames.nth(i).getAttribute("id"));
        }
    }
}
