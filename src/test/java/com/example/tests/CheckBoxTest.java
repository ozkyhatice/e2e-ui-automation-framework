package com.example.tests;
import com.example.pages.CheckBoxPage;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import com.example.data.CheckBoxDataProvider;

public class CheckBoxTest extends BaseTest{
    @Test(dataProvider = "checkboxData", dataProviderClass = CheckBoxDataProvider.class)
    public void checkboxSelectionTest(String label, boolean needsExpand) {

        SoftAssert softAssert = new SoftAssert();
        CheckBoxPage page = new CheckBoxPage(driver);

        page.openPage();

        if (needsExpand) {
            page.expandNode("Home");
        }

        page.clickCheckbox(label);

        softAssert.assertTrue(
                page.areAllChildrenSelected(label),
                label + " checkbox wasn't selected correctly"
        );

        System.out.println(page.getOutputText());

        softAssert.assertAll();
    }
    @Test(dataProvider = "childCheckboxData", dataProviderClass = CheckBoxDataProvider.class)
    public void childCheckboxTest(String[] parents, String child) {
        CheckBoxPage page = new CheckBoxPage(driver);
        page.openPage();
        for (String parent : parents) {
            page.expandNode(parent);
        }

        page.clickCheckbox(child);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(
                page.isCheckboxSelected(child),
                child + " checkbox wasn't selected correctly"
        );
        System.out.println(page.getOutputText());
        softAssert.assertAll();
    }

}