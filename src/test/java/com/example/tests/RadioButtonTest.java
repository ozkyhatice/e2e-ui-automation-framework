package com.example.tests;


import org.testng.annotations.Test;
import com.example.pages.RadioButtonPage;
import org.testng.asserts.SoftAssert;

public class RadioButtonTest extends BaseTest {
    @Test
    public void radioButtonSelectionTest() {
        RadioButtonPage page = new RadioButtonPage(driver);
        page.openPage();
        SoftAssert softAssert = new SoftAssert();
        int size = page.getRadioButtons().size();
        // no is non-selectable, so we iterate until size - 1
        for (int i = 0; i < size - 1; i++) {
            page.getRadioButtons().get(i).click();
            System.out.println("Selected: " + page.getRadioButtons().get(i).getAttribute("id"));
            softAssert.assertTrue(
                    page.getRadioButtons().get(i).isSelected());
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    softAssert.assertFalse(page.getRadioButtons().get(j).isSelected());
                    System.out.println("Not Selected: " + page.getRadioButtons().get(j).getAttribute("id"));
                }
            }
        }
        softAssert.assertAll();
    }
    
}
