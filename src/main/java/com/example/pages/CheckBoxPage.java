package com.example.pages;

import com.example.base.BasePage;
import com.example.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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
    public void clickHome() {
        click(BoxHome);
    }
    public void clickDesktop() {
        click(BoxDesktop);
    }
    public void clickNotes() {
        click(BoxNotes);
    }
    public void clickCommands() {
        click(BoxCommands);
    }
    public void clickDocuments() {
        click(BoxDocuments);
    }
    public void clickWorkspace() {
        click(BoxWorkspace);
    }
    public void clickReact() {
        click(BoxReact);
    }
    public void clickAngular() {
        click(BoxAngular);
    }
    public void clickVeu() {
        click(BoxVeu);}
    public void clickOffice() {
        click(BoxOffice);
    }
    public void clickPublic() {
        click(BoxPublic);
    }
    public void clickPrivate() {
        click(BoxPrivate);
    }
    public void clickClassified() {
        click(BoxClassified);
    }
    public void clickGeneral() {
        click(BoxGeneral);
    }
    public void clickDownloads() {
        click(BoxDownloads);
    }
    public void clickWordFile() {
        click(BoxWordFile);
    }
    public void clickExcelFile() {
        click(BoxExcelFile);
    }
    public boolean isCheckboxSelected(String label) {
        By checkbox = By.cssSelector("span.rc-tree-checkbox[aria-label='Select " + label + "']");
        return driver.findElement(checkbox).getAttribute("aria-checked").equals("true");
    }

    public String getOutputText() {
        return driver.findElement(output).getText();
    }

}
