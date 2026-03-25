package com.example.pages;
import org.openqa.selenium.WebDriver;
import com.example.base.BasePage;
import com.example.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LinksPage extends BasePage {
    private WebDriver driver;
    private String path = "links";

    private By homeLink = By.id("simpleLink");
    private By homeDynamicLink = By.id("dynamicLink");
    public LinksPage(WebDriver driver) {
        super();
        this.driver = super.driver;
    }
    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));
    }
    public String getHomeUrls(WebElement link) {
        wait.until(ExpectedConditions.visibilityOf(link));
        String url = link.getAttribute("href");
        System.out.println("URL: " + url);
        return url;
    }
    public void clickLink(WebElement link) {
        wait.until(ExpectedConditions.elementToBeClickable(link));
        link.click();
    }
    public void clickLinkAndSwitchToNewTab(WebElement link) {
        String originalWindow = driver.getWindowHandle();
        wait.until(ExpectedConditions.elementToBeClickable(link));
        clickLink(link);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    public WebElement getHomeLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeLink));
        return driver.findElement(homeLink);
    }
    public WebElement getHomeDynamicLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeDynamicLink));
        return driver.findElement(homeDynamicLink);
    }
}
