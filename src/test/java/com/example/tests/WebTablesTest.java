package com.example.tests;
import org.testng.annotations.Test;
import com.example.pages.WebTablesPage;
import com.example.data.WebTablesDataProvider;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class WebTablesTest extends BaseTest {
    @Test(dataProvider = "trueCondition", dataProviderClass = WebTablesDataProvider.class)
    public void addNewRecordTest(String firstName, String lastName, String email, String age, String salary, String department) {
        WebTablesPage page = new WebTablesPage(driver);
        page.openPage();
        int initialRowCount = page.getTableRowCount();
        page.clickAddNewRecordButton();
        page.fillRegistrationForm(firstName, lastName, email, age, salary, department);
        page.submitForm();
        int newRowCount = page.getTableRowCount();
        SoftAssert softAssert = new SoftAssert();
        //wait until the new record appears in the table
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedCondition<Boolean>) d -> page.isUserInTable(email));
        softAssert.assertTrue(page.isUserInTable(firstName), "First name not found in table");
        softAssert.assertTrue(page.isUserInTable(lastName), "Last name not found in table");
        softAssert.assertTrue(page.isUserInTable(email), "Email not found in table");
        softAssert.assertTrue(page.isUserInTable(age), "Age not found in table");
        softAssert.assertTrue(page.isUserInTable(salary), "Salary not found in table");
        softAssert.assertTrue(page.isUserInTable(department), "Department not found in table");
        softAssert.assertEquals(newRowCount, initialRowCount + 1, "Row count did not increase by 1");
        softAssert.assertAll();
    }
    @Test
    public void deleteRecordTest() {
        SoftAssert softAssert = new SoftAssert();
        WebTablesPage page = new WebTablesPage(driver);
        page.openPage();
        int initialRowCount = page.getTableRowCount();
        if (initialRowCount == 0) {
            return;
        }
        page.deleteRecordById(1);
        int newRowCount = page.getTableRowCount();
        boolean isDeleted = driver.findElements(By.id("delete-record-1")).isEmpty();
        softAssert.assertTrue(isDeleted, "Record with ID 1 was not deleted");
        softAssert.assertEquals(newRowCount, initialRowCount - 1, "Row count did not decrease by 1");
        softAssert.assertAll();
    }

}
