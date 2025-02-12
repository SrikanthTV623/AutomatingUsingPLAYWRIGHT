package com.automation.basics.screenshots_videos;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Capturing_Screenshots_23 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");

        page.frameLocator("[name='iframeResult']").locator("body > button").click(new Locator.ClickOptions().setTimeout(2000));

        //this helps to get the full page screenshot
        //we import the screenshot options from page
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("/screenshots/screenshot1.png")));

        //this helps to get the particular element screenshot
        //we import the screenshot options from locator
        page.frameLocator("[name='iframeResult']").locator("body > button")
                .screenshot(new Locator.ScreenshotOptions()
                        .setPath(Paths.get("/screenshots/screenshot_element1.png")));

    }
}
