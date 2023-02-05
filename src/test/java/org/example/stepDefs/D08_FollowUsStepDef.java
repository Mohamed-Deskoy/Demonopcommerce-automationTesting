package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P08_FollowUs;
import org.testng.Assert;

import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class D08_FollowUsStepDef {

    P08_FollowUs followus = new P08_FollowUs();


    @When("user clicks on facebook link")
    public void click_facebook() {

        //how to switch between tabs:
        followus.facebook().click();
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
    public void click_twitter() {

        followus.twitter().click();
    }

    @Then("user should be directed to the website twitter page")
    public void twitter() throws InterruptedException {

        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        String expectedResult = "https://twitter.com/nopCommerce";
        String actualResult = driver.switchTo().window(tabs.get(1)).getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }


    @When("user clicks on rss link")
    public void clickRss() {

        followus.rss().click();
    }

    @Then("user should be directed to the website rss page")
    public void rss() throws InterruptedException {

        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        String expectedResult = "https://demo.nopcommerce.com/new-online-store-is-open";
        String actualResult = driver.switchTo().window(tabs.get(1)).getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }


    @When("user clicks on youtube link")
    public void clickYoutube() {

        followus.youtube().click();
    }

    @Then("user should be directed to the website youtube page")
    public void youtube() throws InterruptedException {

        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        String expectedResult = "https://www.youtube.com/user/nopCommerce";
        String actualResult = driver.switchTo().window(tabs.get(1)).getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }


}
