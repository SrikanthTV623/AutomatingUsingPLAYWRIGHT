package com.automation.basics.screenshots_videos;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Trace_Viewer_25 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));

        Page page = context.newPage();
        page.navigate("http://gmail.com");

        page.locator("[type=email]").type("trainer@way2automation.com");
        page.click("button:has-text('Next')");
        page.locator("[type=password]").fill("sdfsdfdsf");
        page.click("button:has-text('Next')");

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));

        page.close();
        context.close();
        playwright.close();
    }
}
