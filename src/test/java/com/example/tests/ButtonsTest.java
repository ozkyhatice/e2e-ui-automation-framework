package com.example.tests;
import com.example.pages.ButtonsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ButtonsTest extends BaseTest {
    @Test
    public void testButtons() {
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        buttonsPage.openPage();
        buttonsPage.clickDoubleClickButton(buttonsPage.getDoubleClickButton());
        buttonsPage.clickRightClickButton(buttonsPage.getRightClickButton());
        buttonsPage.clickClickMeButton(buttonsPage.getClickMeButton());
        softAssert.assertTrue(buttonsPage.isMessageDisplayed("doubleClickMessage"), "Double click message is not displayed");
        softAssert.assertTrue(buttonsPage.isMessageDisplayed("rightClickMessage"), "Right click message is not displayed");
        softAssert.assertTrue(buttonsPage.isMessageDisplayed("dynamicClickMessage"), "Click me message is not displayed");
        softAssert.assertAll();
    }
}
