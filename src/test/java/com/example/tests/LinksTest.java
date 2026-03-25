package com.example.tests;

import org.testng.annotations.Test;
import com.example.pages.LinksPage;
import org.testng.asserts.SoftAssert;

public class LinksTest extends BaseTest {
    @Test
    public void testSimpleLink() {
        LinksPage linksPage = new LinksPage(driver);
        linksPage.openPage();
        String homeUrl = linksPage.getHomeUrls(linksPage.getHomeLink());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homeUrl, "https://demoqa.com/", "Home link URL is incorrect");
        linksPage.clickLinkAndSwitchToNewTab(linksPage.getHomeLink());
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(currentUrl, "https://demoqa.com/", "Did not navigate to the correct URL after clicking Home link");
        softAssert.assertAll();
    }
    @Test
    public void testDynamicLink() {
        LinksPage linksPage = new LinksPage(driver);
        linksPage.openPage();
        String dynamicHomeUrl = linksPage.getHomeUrls(linksPage.getHomeDynamicLink());      
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dynamicHomeUrl, "https://demoqa.com/", "Dynamic link URL is incorrect");
        linksPage.clickLinkAndSwitchToNewTab(linksPage.getHomeDynamicLink());
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(currentUrl, "https://demoqa.com/", "Did not navigate to the correct URL after clicking Dynamic link");
        softAssert.assertAll();
    }
}
