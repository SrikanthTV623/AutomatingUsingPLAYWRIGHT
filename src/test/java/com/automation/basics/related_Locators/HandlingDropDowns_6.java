package com.automation.basics.related_Locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class HandlingDropDowns_6 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");

        //select by value
        page.selectOption("select", "hi");

        //select by text
        page.selectOption("select", new SelectOption().setLabel("Eesti"));

        //select by index
        page.selectOption("select", new SelectOption().setIndex(1));

		/*
		//in this it helps to print all values in dropdown list using locators by for loop.

		Locator values = page.locator("select > option");
		System.out.println(values.count());


		for(int i=0; i<values.count(); i++) {
			System.out.println(values.nth(i).innerText()+"----"+values.nth(i).getAttribute("lang"));
		}
		*/



        //in querySelectorAll all the values in the dropdown are stored in the list
        //printed by using enhanced for loop

        List<ElementHandle> values = page.querySelectorAll("select > option");
        System.out.println(values.size());

        for(ElementHandle value: values) {
            System.out.println(value.innerText()+"----"+value.getAttribute("lang"));
        }

        page.close();
        playwright.close();
    }
}
