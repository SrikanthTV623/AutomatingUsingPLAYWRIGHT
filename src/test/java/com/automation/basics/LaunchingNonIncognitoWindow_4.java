package com.automation.basics;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class LaunchingNonIncognitoWindow_4 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        //this helps to launch the non - incognito window in chromium browser.
        //BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""),new BrowserType.LaunchPersistentContextOptions().setHeadless(false));
        //this helps to launch the non - incognito window in chrome browser present local system.
        //BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""),new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
        //this helps to launch the non - incognito window in chrome browser present local system with user profile which is logged in browser.
        BrowserContext browserContext = playwright.chromium().launchPersistentContext(
                Paths.get("C:\\Users\\280714\\AppData\\Local\\Google\\Chrome\\User Data\\Default"),
                new BrowserType.LaunchPersistentContextOptions().setHeadless(false)
                        .setExecutablePath(Paths.get("C:\\Users\\280714\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe")));

        Page page = browserContext.newPage();
        page.close();
        playwright.close();
    }
}
