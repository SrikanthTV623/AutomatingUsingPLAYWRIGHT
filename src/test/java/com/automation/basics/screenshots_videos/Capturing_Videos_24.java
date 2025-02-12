package com.automation.basics.screenshots_videos;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

import java.nio.file.Paths;
import java.util.List;

public class Capturing_Videos_24 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));

        Page page = context.newPage();
        page.navigate("https://www.wikipedia.org/");

        //select by value
        page.selectOption("select", "hi");

        //select by text
        page.selectOption("select", new SelectOption().setLabel("Eesti"));

        //select by index
        page.selectOption("select", new SelectOption().setIndex(1));


        List<ElementHandle> values = page.querySelectorAll("select > option");
        System.out.println(values.size());

        for (ElementHandle value : values) {
            System.out.println(value.innerText() + "----" + value.getAttribute("lang"));

        }

        page.close();
        context.close();
        playwright.close();
    }
}
