package com.example.tests;


import com.example.data.TextBoxDataProvider;
import com.example.pages.TextBoxPage;
import com.example.utils.RetryAnalyzer;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    @Test(dataProvider = "textboxData", dataProviderClass = TextBoxDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void textboxFormTest(String name, String email, String curr, String perm) {
        SoftAssert softAssert = new SoftAssert();
        TextBoxPage page = new TextBoxPage();

        page.openPage();   
        page.fillForm(name, email, curr, perm);
        page.submit();

        softAssert.assertTrue(page.getOutputName().contains(name));
        softAssert.assertTrue(page.getOutputEmail().contains(email));
        softAssert.assertTrue(page.getOutputCurrentAddress().contains(curr));
        softAssert.assertTrue(page.getOutputPermanentAddress().contains(perm));

    }
}