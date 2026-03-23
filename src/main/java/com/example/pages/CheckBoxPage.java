package com.example.pages;

import com.example.base.BasePage;
import com.example.config.ConfigReader;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckBoxPage extends BasePage {
    private WebDriver driver;
    private String path = "checkbox";

    public CheckBoxPage(WebDriver driver) {
        super();
        this.driver = super.driver;
    }

    private By output = By.id("result");

    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));
    }
    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }
    public void clickCheckbox(String label) {
        By checkbox = By.cssSelector("span.rc-tree-checkbox[aria-label='Select " + label + "']");
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
        scrollIntoView(element);
        click(checkbox);
    }

    public boolean isCheckboxSelected(String label) {
        By checkbox = By.cssSelector("span.rc-tree-checkbox[aria-label='Select " + label + "']");
        return driver.findElement(checkbox).getAttribute("aria-checked").equals("true");
    }

    public String getOutputText() {
        return driver.findElement(output).getText();
    }
    public boolean areAllChildrenSelected(String parentLabel) {
        By childrenLocator = By.xpath(
            "//span[@title='" + parentLabel + "']/ancestor::div[contains(@class,'rc-tree-treenode')]//span[contains(@class,'rc-tree-checkbox')]"
        );

        List<WebElement> children = driver.findElements(childrenLocator);

        for (WebElement child : children) {
            if (!child.getAttribute("aria-checked").equals("true")) {
                return false;
            }
        }
        return true;
    }
    public void expandNode(String label) {
        By switcherLocator = By.xpath("//span[@title='" + label + "']/preceding-sibling::span[contains(@class,'rc-tree-switcher')]");
        
        WebElement switcher = wait.until(ExpectedConditions.presenceOfElementLocated(switcherLocator));
        scrollIntoView(switcher);

        if (switcher.getAttribute("class").contains("close")) {
            switcher.click();
            try {
                new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.attributeContains(switcherLocator, "class", "open"));
            } catch (Exception e) {
                System.out.println(label + " node couldn't be expanded.");
            }
        }
    }
}
