package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P6_HoverCategories;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Random;

import static org.example.stepDefs.Hooks.driver;

public class D6_HoverOnCategoriesStepDef {

    P6_HoverCategories p6HoverCategories = new P6_HoverCategories();

    @When("user select random one of the three main categories")
    public void categorySelection(){
        int i = new Random().nextInt(3);
        Actions actions = new Actions(driver);
        actions.moveToElement(p6HoverCategories.categories().get(i)).perform();
    }
    @Then("user could hover on sub categories of the selected main category")
    public void hoverSubCategory(){
        int i = new Random().nextInt(3);
        int i1 = new Random().nextInt(3,6);
        int i2 = new Random().nextInt(6,9);
        String s = "a";
        if(p6HoverCategories.desktop().isDisplayed() || p6HoverCategories.notebooks().isDisplayed() || p6HoverCategories.software().isDisplayed())
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(p6HoverCategories.subCategories().get(i)).perform();
            s = p6HoverCategories.subCategories().get(i).getText();
            p6HoverCategories.subCategories().get(i).click();
        }

        else if(p6HoverCategories.cellphones().isDisplayed() || p6HoverCategories.others().isDisplayed() || p6HoverCategories.camera_and_photo().isDisplayed())
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(p6HoverCategories.subCategories().get(i1)).perform();
            s = p6HoverCategories.subCategories().get(i1).getText();
            p6HoverCategories.subCategories().get(i1).click();
        }

        else if(p6HoverCategories.clothing().isDisplayed() || p6HoverCategories.accessories().isDisplayed() || p6HoverCategories.shoes().isDisplayed())
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(p6HoverCategories.subCategories().get(i2)).perform();
            s = p6HoverCategories.subCategories().get(i2).getText();
            p6HoverCategories.subCategories().get(i2).click();
        }
            Assert.assertTrue(p6HoverCategories.subPage_Title().getText().contains(s));
    }
}
