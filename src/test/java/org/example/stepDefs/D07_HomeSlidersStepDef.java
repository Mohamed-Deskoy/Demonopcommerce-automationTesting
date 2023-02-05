package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P07_HomeSliders;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class D07_HomeSlidersStepDef {

    P07_HomeSliders slider = new P07_HomeSliders();


    @When("user clicks on the Nokia Lumia 1020 slider")
    public void clickNokiaSlider() {

        slider.slider().get(0).click();
    }

    @Then("user should be directed to iPhone page")
    public void nokiaPage() {

        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/nokia-lumia-1020");

    }

    @When("user clicks on the iPhone slider")
    public void clickIPhoneSlider() {

        slider.slider().get(0).click();
    }

    @Then("user should be directed to Nokia Lumia 1020 page")
    public void iphone_Page() {

        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/iphone-6");

    }
}
