package com.example.tests;
import com.example.pages.CheckBoxPage;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
public class CheckBoxTest extends BaseTest{
    @Test
    public void homeCheckBoxTest() {
        SoftAssert softAssert = new SoftAssert();
        CheckBoxPage page = new CheckBoxPage(driver);

        page.openPage();

        page.clickCheckbox("Home");

        softAssert.assertTrue(page.areAllChildrenSelected("Home"), "Checkbox wasn't selected correctly");
        System.out.println(page.getOutputText());

        softAssert.assertAll();
    }
    
    
}
