package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "summary")
    private WebElement summaryField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(xpath = "//input[@value='Submit Issue']")
    private WebElement submitIssueButton;

    @FindBy(css = "table#buglist tr:first-child>td.column-id")
    private WebElement issueId;

    @FindBy(xpath = "//td[@class='bug-id']")
    private WebElement idViewIssuesDetails;

    @FindBy(xpath = "//td[@class='bug-description']")
    private WebElement descriptionViewIssuesDetails;

    @FindBy(xpath = "//td[@class='bug-summary']")
    private WebElement summaryViewIssuesDetails;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteIssueButton;

    @FindBy(css = "tbody>tr:nth-child(4)>td:first-child")
    private WebElement idDeleteIssues;

    @FindBy(css = "tbody>tr:nth-child(4)>td:nth-child(2)")
    private WebElement summaryDeleteIssues;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement lastDeleteIssues;


    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);

    }

    public String summary(String summary) {
        summaryField.sendKeys(summary);
        summaryField.sendKeys(Keys.ENTER);
        return summary;
    }

    public String description(String description) {
        descriptionField.sendKeys(description);
        return description;
    }

    public void submitIssue() {
        submitIssueButton.click();
    }

    public String getIssueId() {
        return issueId.getText();
    }

    public String getIdViewIssueDetails() {
        return idViewIssuesDetails.getText();
    }

    public void isIssueId() {
        issueId.click();
    }

    public String getDescriptionViewIssuesDetails() {
        return descriptionViewIssuesDetails.getText();
    }


    public String getSummaryDeleteIssues() {
        return summaryDeleteIssues.getText();
    }


    public void deleteIssueButton() {
        deleteIssueButton.click();
    }

    public String getIdDeleteIssues() {
        return idDeleteIssues.getText();

    }

    public void lastDeleteIssues() {
        lastDeleteIssues.click();
    }
}


