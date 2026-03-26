package com.example.pages;
import com.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import com.example.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UploadDownloadPage extends BasePage {
    private WebDriver driver;
    private String path = "upload-download";
    private By inputFile = By.id("uploadFile");
    private By downloadButton = By.id("downloadButton");
    public UploadDownloadPage(WebDriver driver) {
        super();
        this.driver = super.driver;
    }
    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));
    }
    public String getAbsoulatePath(String fileName) {
        String userDir = System.getProperty("user.dir");
        System.out.println("User Directory: " + userDir);
        String filePath = userDir + "/src/test/resources/files/" + fileName;
        return filePath;
    }
    public void uploadFile(String filePath) {
        driver.findElement(inputFile).sendKeys(filePath);
    }
    public void clickDownloadButton() {
        wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
        driver.findElement(downloadButton).click();
    }

}
