package com.example.pages;
import com.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import com.example.config.ConfigReader;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ButtonsPage extends BasePage {
    private WebDriver driver;
    private String path = "buttons";

    public ButtonsPage(WebDriver driver) {
        super();
        this.driver = super.driver;
    }
    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));
    }
    public void clickDoubleClickButton(WebElement doubleClickBtn) {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(doubleClickBtn));
        actions.doubleClick(doubleClickBtn).perform();
    }
    public void clickRightClickButton(WebElement rightClickBtn) {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(rightClickBtn));
        actions.contextClick(rightClickBtn).perform();
    }
    public void clickClickMeButton(WebElement clickMeBtn) {
        wait.until(ExpectedConditions.elementToBeClickable(clickMeBtn));
        clickMeBtn.click();
    }
        
    
}
