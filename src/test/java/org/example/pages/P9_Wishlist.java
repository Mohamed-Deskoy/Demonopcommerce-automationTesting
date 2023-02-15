package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P9_Wishlist {

    public List<WebElement> wishlist_btn() {
        List<WebElement> elements = driver.findElements(By.cssSelector("div[class=\"add-info\"]>div[class=\"buttons\"]>button[class=\"button-2 add-to-wishlist-button\"]"));
        return elements;
    }

    public WebElement wishlistTab() {
        return driver.findElement(By.className("wishlist-label"));
    }

    public WebElement successMsg() {
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

}
