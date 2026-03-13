package com.example.tests;
import com.example.pages.CheckBoxPage;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
public class CheckBoxTest extends BaseTest{
    @Test
    public void HomeCheckBoxTest() {
        SoftAssert softAssert = new SoftAssert();
        CheckBoxPage page = new CheckBoxPage(driver);

        page.openPage();
        page.clickHome();
        softAssert.assertTrue(page.getOutputText().contains("You have selected :home"));
    }
    
}
