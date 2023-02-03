package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P06_HoverCategories_WebElements;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Random;

import static org.example.stepDefs.Hooks.driver;

public class D06_HoverOnCategories_StepDefinitions {

    P06_HoverCategories_WebElements hovercategorie = new P06_HoverCategories_WebElements();

    @When("user select random one of the three main categories")
    public void categorySelection(){

        int randomNumber = new Random().nextInt(3);


        Actions hover = new Actions(driver);

        hover.moveToElement(hovercategorie.categories().get(randomNumber)).perform();
    }


    @Then("user could hover on sub categories of the selected main category")
    public void hoverSubCategory(){


        int RandomNumber1 = new Random().nextInt(3);
        int RandomNumber2 = new Random().nextInt(3,6);
        int RandomNumber3 = new Random().nextInt(6,9);

        String subTitle = "a";

        if(hovercategorie.desktop().isDisplayed() || hovercategorie.notebooks().isDisplayed() || hovercategorie.software().isDisplayed())
        {
            Actions hover = new Actions(driver);
            hover.moveToElement(hovercategorie.subCategories().get(RandomNumber1)).perform();
            subTitle = hovercategorie.subCategories().get(RandomNumber1).getText();
            hovercategorie.subCategories().get(RandomNumber1).click();
        }

        else if(hovercategorie.cellphones().isDisplayed() || hovercategorie.others().isDisplayed() || hovercategorie.camera_and_photo().isDisplayed())
        {
            Actions hover = new Actions(driver);
            hover.moveToElement(hovercategorie.subCategories().get(RandomNumber2)).perform();
            subTitle = hovercategorie.subCategories().get(RandomNumber2).getText();
            hovercategorie.subCategories().get(RandomNumber2).click();
        }


        else if(hovercategorie.clothing().isDisplayed() || hovercategorie.accessories().isDisplayed() || hovercategorie.shoes().isDisplayed())
        {
            Actions hover = new Actions(driver);
            hover.moveToElement(hovercategorie.subCategories().get(RandomNumber3)).perform();
            subTitle = hovercategorie.subCategories().get(RandomNumber3).getText();
            hovercategorie.subCategories().get(RandomNumber3).click();
        }

            Assert.assertTrue(hovercategorie.subPage_Title().getText().contains(subTitle));
    }
}
