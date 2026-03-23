package com.example.pages;
import com.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.config.ConfigReader;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebTablesPage extends BasePage {
    private WebDriver driver;
    private String path = "webtables";

    public WebTablesPage(WebDriver driver) {
        super();
        this.driver = super.driver;
    }
    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));
    }

    public void clickAddNewRecordButton() {
        By addButton = By.id("addNewRecordButton");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        element.click();
    }

    public void fillRegistrationForm(String firstName, String lastName, String email, String age, String salary, String department) {
        By textForm = By.id("registration-form-modal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(textForm));
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(age);
        driver.findElement(By.id("salary")).sendKeys(salary);
        driver.findElement(By.id("department")).sendKeys(department);
    }

    public void submitForm() {
        By submitButton = By.id("submit");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        element.click();
    }

    public boolean isUserInTable(String value) {
    return driver.findElements(By.xpath("//table/tbody/tr"))
            .stream()
            .anyMatch(row -> row.getText().contains(value));
    }
    public int getTableRowCount() {
        return driver.findElements(By.xpath("//table/tbody/tr")).size();
    }

    public void deleteRecordById(int recordId) {
        By deleteBtn = By.id("delete-record-" + recordId);
        click(deleteBtn);
}
    

}
