package com.example.pages;


import com.example.base.BasePage;
import com.example.config.ConfigReader;
import org.openqa.selenium.By;


public class TextBoxPage extends BasePage {

    private String path = "text-box";

    private By nameInput = By.id("userName");
    private By emailInput = By.id("userEmail");
    private By currentAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");
    private By submitBtn = By.id("submit");
    private By outputName = By.id("name");

    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));
    }

    public void fillForm(String name, String email, String currAddr, String permAddr) {
        type(nameInput, name);
        type(emailInput, email);
        type(currentAddress, currAddr);
        type(permanentAddress, permAddr);
    }

    public void submit() {
        click(submitBtn);
    }

    public String getOutputName() {
        return getText(outputName);
    }
}