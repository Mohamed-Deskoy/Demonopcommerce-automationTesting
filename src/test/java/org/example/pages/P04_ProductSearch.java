package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P04_ProductSearch {

    public List<WebElement> serialNumbersList(){

        List<WebElement> serialNumber = driver.findElements(By.cssSelector("div[class=\"sku\"] > span[class=\"value\"]"));

        return serialNumber;
    }

    public List<WebElement> productsNamesList(){

        List<WebElement> productTitle = driver.findElements(By.className("product-title"));

        return productTitle;
    }
    public WebElement product_found(){
        return driver.findElement(By.cssSelector("h2[class=\"product-title\"] > a[href=\"/lenovo-thinkpad-x1-carbon-laptop\"]"));
    }

    public WebElement search_Box(){
       return driver.findElement(By.id("small-searchterms"));
    }

    public WebElement search_Button(){
        return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
    }

}
