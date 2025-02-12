package com.automation.basics.related_tables;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Handling_WebTables_27 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://money.rediff.com/indices/nse/NIFTY-50?src=moneyhome_nseIndices");

        //Row count of web table
        System.out.println(page.locator(".dataTable > tbody").locator("tr").count());

        //col count of web table
        System.out.println(page.locator(".dataTable > tbody").locator("tr:first-child").locator("td").count());

        //this helps to validate where column 2 contains only nifty as a text.
        assertThat(page.locator(".dataTable > tbody").locator("tr:first-child").locator("td:nth-child(2)")).hasText("Nifty");

        //this helps to print entire data of web table
        page.locator(".dataTable > tbody").allInnerTexts().forEach(text -> System.out.println(text));

    }
}
