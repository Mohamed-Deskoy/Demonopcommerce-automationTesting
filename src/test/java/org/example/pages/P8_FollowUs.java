package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;

public class P8_FollowUs {
    public WebElement youtube() {
        return driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }

    public WebElement facebook() {
        return driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
    }

    public WebElement Rs() {
        return driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));
    }

    public WebElement twitter() {
        return driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
    }

}
