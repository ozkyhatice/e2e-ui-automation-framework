package com.example.tests;

import com.example.pages.BrokenLinksPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BrokenLinksTest extends BaseTest {

    @Test
    public void verifyImagesAndLinks() {
        BrokenLinksPage page = new BrokenLinksPage(driver);
        SoftAssert softAssert = new SoftAssert();

        page.openPage();

        // --- Image checks ---
        softAssert.assertTrue(
            page.isImageBroken(page.getValidImage()),
            "error: valid image should NOT be broken"
        );
        softAssert.assertTrue(
            page.isImageBroken(page.getBrokenImage()),
            "error: broken image should BE broken"
        );

        // --- Link checks ---
        int validLinkStatus = page.getLinkHTTPStatus(page.getValidLink());
        softAssert.assertTrue(
            validLinkStatus >= 200 && validLinkStatus < 400,
            "error: valid link returned bad status: " + validLinkStatus
        );

        int brokenLinkStatus = page.getLinkHTTPStatus(page.getBrokenLink());
        softAssert.assertTrue(
            brokenLinkStatus >= 400,
            "error: broken link should return 4xx status, got: " + brokenLinkStatus
        );

        softAssert.assertAll();
    }
}