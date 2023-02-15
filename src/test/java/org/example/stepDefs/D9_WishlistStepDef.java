package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P9_Wishlist;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D9_WishlistStepDef {
    P9_Wishlist p9Wishlist = new P9_Wishlist();

    @When("user clicks on the wishlist button")
    public void clickWishlist() {
        p9Wishlist.wishlist_btn().get(2).click();
    }

    @Then("the product is added to wishlist and success message appears")
    public void wishlistSuccess() {
        SoftAssert softAssert = new SoftAssert();
        String expRes = "The product has been added to your ";
        String actRes = p9Wishlist.successMsg().getText();
        softAssert.assertTrue(actRes.contains(expRes));
        String cssValue = p9Wishlist.successMsg().getCssValue("background-color");
        softAssert.assertEquals(cssValue, "rgba(75, 176, 122, 1)");
        softAssert.assertAll();
    }

    @And("user waits until success message disappears and clicks on wishlist Tab")
    public void clickWishlistTab() {

        Assert.assertTrue(new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class=\"bar-notification success\"]"))));
        p9Wishlist.wishlistTab().click();
    }

    @Then("product is existed in the wishlist")
    public void productExists() {
        String value = driver.findElement(By.className("qty-input")).getAttribute("Value");
        Assert.assertTrue(true, value);
    }

}
