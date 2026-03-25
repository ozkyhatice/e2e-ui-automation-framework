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
    @Test
    public void testCreatedLink() {
        LinksPage linksPage = new LinksPage(driver);
        linksPage.openPage();
        linksPage.clickLink(linksPage.getCreatedLink());
        String responseText = linksPage.getResponseText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(responseText.contains("201"), "Response does not contain expected status code 201");
        softAssert.assertAll();
    }
    @Test
    public void testNoContentLink() {
        LinksPage linksPage = new LinksPage(driver);
        linksPage.openPage();
        linksPage.clickLink(linksPage.getNoContentLink());
        String responseText = linksPage.getResponseText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(responseText.contains("204"), "Response does not contain expected status code 204");
        softAssert.assertAll();
    }
    @Test
    public void testMovedLink() {
        LinksPage linksPage = new LinksPage(driver);
        linksPage.openPage();
        linksPage.clickLink(linksPage.getMovedLink());
        String responseText = linksPage.getResponseText();  
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(responseText.contains("301"), "Response does not contain expected status code 301");
        softAssert.assertAll();
    }
    @Test
    public void testBadRequestLink() {
        LinksPage linksPage = new LinksPage(driver);
        linksPage.openPage();
        linksPage.clickLink(linksPage.getBadRequestLink());
        String responseText = linksPage.getResponseText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(responseText.contains("400"), "Response does not contain expected status code 400");
        softAssert.assertAll();
    }
    @Test
    public void testUnauthorizedLink() {
        LinksPage linksPage = new LinksPage(driver);
        linksPage.openPage();
        linksPage.clickLink(linksPage.getUnauthorizedLink());
        String responseText = linksPage.getResponseText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(responseText.contains("401"), "Response does not contain expected status code 401");
        softAssert.assertAll(); 
    }
    @Test
    public void testForbiddenLink() {
        LinksPage linksPage = new LinksPage(driver);
        linksPage.openPage();
        linksPage.clickLink(linksPage.getForbiddenLink());
        String responseText = linksPage.getResponseText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(responseText.contains("403"), "Response does not contain expected status code 403");
        softAssert.assertAll();
    }

}
