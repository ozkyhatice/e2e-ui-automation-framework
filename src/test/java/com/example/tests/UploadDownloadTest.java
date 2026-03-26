package com.example.tests;

import java.io.File;

import org.testng.annotations.Test;
import com.example.pages.UploadDownloadPage;
import org.testng.Assert;

public class UploadDownloadTest extends BaseTest {
    @Test
    public void testFileUpload() {
        UploadDownloadPage uploadDownloadPage = new UploadDownloadPage(driver);
        uploadDownloadPage.openPage();
        String filePath = uploadDownloadPage.getAbsoulatePath("sampleFile.jpeg");
        uploadDownloadPage.uploadFile(filePath);
    }
   @Test
    public void testFileDownload() {
        UploadDownloadPage page = new UploadDownloadPage(driver);
        page.openPage();

        String downloadPath = System.getProperty("user.dir") + "/target/downloads";
        File downloadedFile = new File(downloadPath + "/sampleFile.jpeg");

        if (downloadedFile.exists()) {
            downloadedFile.delete();
        }

        page.clickDownloadButton();

        org.openqa.selenium.support.ui.FluentWait<File> wait = 
            new org.openqa.selenium.support.ui.FluentWait<>(downloadedFile)
                .withTimeout(java.time.Duration.ofSeconds(10))
                .pollingEvery(java.time.Duration.ofMillis(500))
                .ignoring(Exception.class);

        boolean isDownloaded = wait.until(file -> file.exists() && file.length() > 0);

        Assert.assertTrue(isDownloaded, "Download failed or timed out!");
        
        downloadedFile.delete();
    }

}
