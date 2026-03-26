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
    public void testFileDownload() throws InterruptedException {
        UploadDownloadPage page = new UploadDownloadPage(driver);
        page.openPage();

        String homePath = System.getProperty("user.home");
        String downloadDirPath = homePath + "/Downloads";
        String downloadedFileName = "sampleFile.jpeg";
        File downloadedFile = new File(downloadDirPath + "/" + downloadedFileName);

        if (downloadedFile.exists()) {
            downloadedFile.delete();
        }

        page.clickDownloadButton();

        Thread.sleep(3000); 

        Assert.assertTrue(downloadedFile.exists(), "Download failed: File does not exist in the downloads folder.");
        
        Assert.assertTrue(downloadedFile.length() > 0, "Download failed: File is empty (0 bytes).");
        
        downloadedFile.delete();
    }

}
