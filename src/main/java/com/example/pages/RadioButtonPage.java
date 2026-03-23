package com.example.pages;
import com.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import com.example.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class RadioButtonPage extends BasePage {
    private WebDriver driver;
    private String path = "radio-button";
    
    public RadioButtonPage(WebDriver driver) {
        super();
        this.driver = super.driver;
    }
    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));
    }
    public List<WebElement> getRadioButtons() {
        return driver.findElements(By.cssSelector("input[type='radio']"));
    }
}
