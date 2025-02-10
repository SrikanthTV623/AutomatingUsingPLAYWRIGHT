package com.automation.basics.related_Browser;

import com.microsoft.playwright.*;

import java.util.ArrayList;

public class MaximizingTheWindow_2 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        /*
        //1st Method we are giving screen size (in width and height)
        Browser browser = playwright.firefox()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new
                Browser.NewContextOptions().setViewportSize(1920,769));
        Page page = browserContext.newPage();
         */

        /*
        //instead of hardcoding
        //we can calculate the screen resolution at run time
        //2nd method
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        Browser browser = playwright.firefox()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new
                Browser.NewContextOptions().setViewportSize((int)width,(int)height));
        Page page = browserContext.newPage();
         */


        //another simple and easiest way to maximize the window
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
        //Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Users\\280714\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe")));
        BrowserContext context = browser.newContext(new
                Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();

        page.navigate("http://playwright.dev");
        System.out.println(page.title());
    }
}
