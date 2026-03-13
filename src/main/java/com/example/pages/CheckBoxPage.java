package com.example.pages;

import com.example.base.BasePage;
import com.example.config.ConfigReader;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckBoxPage extends BasePage {
    private WebDriver driver;
    private String path = "checkbox";

    public CheckBoxPage(WebDriver driver) {
        super();
        this.driver = super.driver;
    }

    //1
    private By BoxHome = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Home']");


    //1-1
    private By BoxDesktop = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Desktop']");
    //1-1-1
    private By BoxNotes = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Notes']");
    //1-1-2
    private By BoxCommands = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Commands']");


    //1-2
    private By BoxDocuments = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Documents']");
    //1-2-1
    private By BoxWorkspace = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Workspace']");
    private By BoxReact = By.cssSelector("span.rc-tree-checkbox[aria-label='Select React']");
    private By BoxAngular = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Angular']");
    private By BoxVeu = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Veu']");
    //1-2-2
    private By BoxOffice = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Office']");
    private By BoxPublic = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Public']");
    private By BoxPrivate = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Private']");
    private By BoxClassified = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Classified']");
    private By BoxGeneral = By.cssSelector("span.rc-tree-checkbox[aria-label='Select General']");



    //1-3
    private By BoxDownloads = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Downloads']");
    private By BoxWordFile = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Word File.doc']");
    private By BoxExcelFile = By.cssSelector("span.rc-tree-checkbox[aria-label='Select Excel File.doc']");

    private By output = By.id("result");

    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));
    }
    public void clickCheckbox(String label) {
        By checkbox = By.cssSelector("span.rc-tree-checkbox[aria-label='Select " + label + "']");
        click(checkbox);
    }

    public boolean isCheckboxSelected(String label) {
        By checkbox = By.cssSelector("span.rc-tree-checkbox[aria-label='Select " + label + "']");
        return driver.findElement(checkbox).getAttribute("aria-checked").equals("true");
    }

    public String getOutputText() {
        return driver.findElement(output).getText();
    }
    public boolean areAllChildrenSelected(String parentLabel) {
        By childrenLocator = By.xpath(
            "//span[@title='" + parentLabel + "']/ancestor::div[contains(@class,'rc-tree-treenode')]//span[contains(@class,'rc-tree-checkbox')]"
        );

        List<WebElement> children = driver.findElements(childrenLocator);

        for (WebElement child : children) {
            if (!child.getAttribute("aria-checked").equals("true")) {
                return false;
            }
        }
        return true;
    }

}
