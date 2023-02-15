package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P8_FollowUs;
import org.testng.Assert;

import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class D8_FollowUsStepDef {
    P8_FollowUs p8FollowUs = new P8_FollowUs();
    @When("user clicks on facebook link")
    public void click_facebook() {

        p8FollowUs.facebook().click();
    }

    @Then("user should be directed to the website facabook page")
    public void facebookPage() throws InterruptedException {

        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String expectedResult = "https://www.facebook.com/nopCommerce";
        String actualResult = driver.switchTo().window(tabs.get(1)).getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
    @When("user clicks on twitter link")
    public void clickTwitter() {
        p8FollowUs.twitter().click();
    }
    @Then("user should be directed to the website twitter page")
    public void twitter() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> arrayList = new ArrayList<>(driver.getWindowHandles());
        String expRes = "https://twitter.com/nopCommerce";
        String actRes = driver.switchTo().window(arrayList.get(1)).getCurrentUrl();
        Assert.assertEquals(actRes, expRes);
    }
    @When("user clicks on rss link")
    public void clickRss() {
        p8FollowUs.Rs().click();
    }
    @Then("user should be directed to the website rss page")
    public void RS() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> arrayList = new ArrayList<>(driver.getWindowHandles());
        String expRes = "https://demo.nopcommerce.com/new-online-store-is-open";
        String actRes = driver.switchTo().window(arrayList.get(1)).getCurrentUrl();
        Assert.assertEquals(actRes, expRes);
    }

    @When("user clicks on youtube link")
    public void clickYoutube() {
        p8FollowUs.youtube().click();
    }
    @Then("user should be directed to the website youtube page")
    public void youtube() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> arrayList = new ArrayList<>(driver.getWindowHandles());
        String expRes = "https://www.youtube.com/user/nopCommerce";
        String actRes = driver.switchTo().window(arrayList.get(1)).getCurrentUrl();
        Assert.assertEquals(actRes, expRes);
    }
}
