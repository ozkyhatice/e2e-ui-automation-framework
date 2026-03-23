package com.example.tests;
import org.testng.annotations.Test;
import com.example.pages.WebTablesPage;
import com.example.data.WebTablesDataProvider;
import org.testng.asserts.SoftAssert;


public class WebTablesTest extends BaseTest {
    @Test(dataProvider = "trueCondition", dataProviderClass = WebTablesDataProvider.class)
    public void addNewRecordTest(String firstName, String lastName, String email, String age, String salary, String department) {
        WebTablesPage page = new WebTablesPage(driver);
        page.openPage();
        page.clickAddNewRecordButton();
        page.fillRegistrationForm(firstName, lastName, email, age, salary, department);
        page.submitForm();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.isUserInTable(firstName), "First name not found in table");
        softAssert.assertTrue(page.isUserInTable(lastName), "Last name not found in table");
        softAssert.assertTrue(page.isUserInTable(email), "Email not found in table");
        softAssert.assertTrue(page.isUserInTable(age), "Age not found in table");
        softAssert.assertTrue(page.isUserInTable(salary), "Salary not found in table");
        softAssert.assertTrue(page.isUserInTable(department), "Department not found in table");
        softAssert.assertAll();
    }
}
