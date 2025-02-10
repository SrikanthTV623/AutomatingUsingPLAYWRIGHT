package com.automation.basics.related_Javascript;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Evaluating_JS_17 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("http://google.com");

        //this helps to print current url which is opened in the window.
        System.out.println(page.evaluate("document.location.href"));

        //this part of code creates a textbox on that window and we type text on it.
        page.evaluate("() => {"
                + "const textarea = document.createElement('textarea');"
                + "document.body.append(textarea);"
                + "textarea.focus();"
                + "}");

        String text = "Hello World !!";

        //here we locate that textbox using the keyboard() function.
        page.keyboard().type(text);
    }
}
