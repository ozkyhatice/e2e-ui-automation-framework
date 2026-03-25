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
        buttonsPage.openPage();
        buttonsPage.clickDoubleClickButton(buttonsPage.getDoubleClickButton());
        buttonsPage.clickRightClickButton(buttonsPage.getRightClickButton());
        buttonsPage.clickClickMeButton(buttonsPage.getClickMeButton());
        SoftAssert softAssert = new SoftAssert();
        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        softAssert.assertTrue(doubleClickMessage.isDisplayed(), "Double click message is not displayed");
        softAssert.assertTrue(rightClickMessage.isDisplayed(), "Right click message is not displayed");
        softAssert.assertTrue(dynamicClickMessage.isDisplayed(), "Dynamic click message is not displayed");
        softAssert.assertAll();
}
}
