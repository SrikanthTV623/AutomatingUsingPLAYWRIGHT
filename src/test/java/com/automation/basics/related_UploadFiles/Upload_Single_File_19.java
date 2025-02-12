package com.automation.basics.related_UploadFiles;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class Upload_Single_File_19 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

        page.locator("#register_form > fieldset:nth-child(9) > input[type=file]")
                .setInputFiles(Paths.get("src/test/resources/Files/Xpath+vs+CSS.pdf"));

    }
}
