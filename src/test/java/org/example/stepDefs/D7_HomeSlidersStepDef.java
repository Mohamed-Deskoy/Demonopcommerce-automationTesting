package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P7_HomeSliders;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class D7_HomeSlidersStepDef {

    P7_HomeSliders p7HomeSliders = new P7_HomeSliders();

    @When("user clicks on the Nokia Lumia 1020 slider")
    public void clickNokiaSlider() {
        p7HomeSliders.slider().get(0).click();
    }
    @Then("user should be directed to iPhone page")
    public void nokiaPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/nokia-lumia-1020");

    }
    @When("user clicks on the iPhone slider")
    public void clickIPhoneSlider() {
        p7HomeSliders.slider().get(0).click();
    }

    @Then("user should be directed to Nokia Lumia 1020 page")
    public void iphonePage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/iphone-6");
    }
}
