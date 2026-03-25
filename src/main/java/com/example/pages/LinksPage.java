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
    private By createdLink = By.id("created");
    private By noContentLink = By.id("no-content");
    private By movedLink = By.id("moved");
    private By badRequestLink = By.id("bad-request");
    private By unauthorizedLink = By.id("unauthorized");
    private By forbiddenLink = By.id("forbidden");
    private By notFoundLink = By.id("invalid-url");
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
        try {
            ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", link);
            
            Thread.sleep(500); 
            
            link.click();
        } catch (Exception e) {
            System.out.println("Click action failed: " + e.getMessage());
            ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", link);
        }
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
    public WebElement getCreatedLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createdLink));
        return driver.findElement(createdLink);
    }
    public WebElement getNoContentLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(noContentLink));
        return driver.findElement(noContentLink);
    }
    public WebElement getMovedLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(movedLink));
        return driver.findElement(movedLink);
    }
    public WebElement getBadRequestLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(badRequestLink));
        return driver.findElement(badRequestLink);
    }
    public WebElement getUnauthorizedLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(unauthorizedLink));
        return driver.findElement(unauthorizedLink);
    }
    public WebElement getForbiddenLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(forbiddenLink));
        return driver.findElement(forbiddenLink);
    }
    public WebElement getNotFoundLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(notFoundLink));
        return driver.findElement(notFoundLink);
    }
    public String getResponseText() {
        By responseLocator = By.id("linkResponse");
        wait.until(ExpectedConditions.visibilityOfElementLocated(responseLocator));
        return driver.findElement(responseLocator).getText();
    }
}
