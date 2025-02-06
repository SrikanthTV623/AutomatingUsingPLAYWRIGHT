package com.automation.basics;

import com.microsoft.playwright.*;

public class HandlingAlerts_9 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");

        page.onDialog(dialog -> {
            //here we added thread.sleep to see how browser handles the alerts.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            dialog.accept(); //accepts the alerts
            System.out.println(dialog.message()); //helps to print the text present in alert box.
        });

        page.locator("[type='submit']").click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        page.close();
        browser.close();
        playwright.close();
    }
}
