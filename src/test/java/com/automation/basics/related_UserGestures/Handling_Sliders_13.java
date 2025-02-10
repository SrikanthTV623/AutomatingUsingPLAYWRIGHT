package com.automation.basics.related_UserGestures;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Locator;

public class Handling_Sliders_13 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://jqueryui.com/resources/demos/slider/default.html");

        Locator slider = page.locator("//*[@id=\"slider\"]/span");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Move the mouse (optional, if you need to drag something)
        page.mouse().move(slider.boundingBox().x + slider.boundingBox().width / 2, slider.boundingBox().y + slider.boundingBox().height / 2);

        // Press the mouse button down
        page.mouse().down();

        // Move the mouse (optional, if you need to drag something)
        page.mouse().move(slider.boundingBox().x + 400, slider.boundingBox().y + slider.boundingBox().height / 2);

        // Release the mouse button
        page.mouse().up();


    }
}
