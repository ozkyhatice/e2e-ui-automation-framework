package com.example.pages;
import com.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import com.example.config.ConfigReader;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.net.URL;

public class BrokenLinksPage extends BasePage {
    private WebDriver driver;
    private String path = "broken";
    private By validImg = By.xpath("//img[@src='/images/Toolsqa.jpg']");
    private By brokenImg = By.xpath("//img[@src='/images/Toolsqa_1.jpg']");
    private By validLink = By.xpath("//a[@href='http://demoqa.com']");
    private By brokenLink = By.xpath("//a[@href='http://the-internet.herokuapp.com/status_codes/500']");
    public BrokenLinksPage(WebDriver driver) {
        super();
        this.driver = super.driver;
    }
    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));  
    }
    public WebElement getValidImage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(validImg));
        return driver.findElement(validImg);
    }
    public WebElement getBrokenImage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(brokenImg));
        return driver.findElement(brokenImg);
    }
    public WebElement getValidLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(validLink));
        return driver.findElement(validLink);
    }
    public WebElement getBrokenLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(brokenLink));
        return driver.findElement(brokenLink);
    }
    public boolean isImageBroken(WebElement image) {
        if (image == null) {
            return true; 
        }

        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            
            String script = "return arguments[0].naturalWidth === 0 || typeof arguments[0].naturalWidth === 'undefined';";
            
            Boolean isBroken = (Boolean) jsExecutor.executeScript(script, image);
            
            return isBroken != null ? isBroken : true;
            
        } catch (Exception e) {
            System.err.println("Failed to execute JavaScript for image verification: " + e.getMessage());
            
            return true; 
        }
    }
    private int getHttpStatus(String url) {
        if (url == null || url.isEmpty()) {
            return -1;
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);            
            connection.connect();
            return connection.getResponseCode();
            
        } catch (Exception e) {
            System.err.println("Failed to connect to URL [" + url + "]: " + e.getMessage());
            return -1; 
        }
    }
    public int getLinkHTTPStatus(WebElement link) {
        if (link == null) {
            return -1;
        }
        String url = link.getAttribute("href");
        return getHttpStatus(url);
    }
}
