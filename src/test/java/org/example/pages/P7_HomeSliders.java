package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P7_HomeSliders {

    public List<WebElement> slider() {

        List<WebElement> elements = driver.findElements(By.cssSelector("div[id=\"nivo-slider\"]>a[href=\"http://demo.nopcommerce.com/\"]"));
        return elements;
    }
}
