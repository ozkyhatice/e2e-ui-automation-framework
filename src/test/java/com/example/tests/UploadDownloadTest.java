package com.example.tests;

import org.testng.annotations.Test;
import com.example.pages.UploadDownloadPage;

public class UploadDownloadTest extends BaseTest {
    @Test
    public void testFileUpload() {
        UploadDownloadPage uploadDownloadPage = new UploadDownloadPage(driver);
        uploadDownloadPage.openPage();
        String filePath = uploadDownloadPage.getAbsoulatePath("sampleFile.jpeg");
        uploadDownloadPage.uploadFile(filePath);
    }
}
