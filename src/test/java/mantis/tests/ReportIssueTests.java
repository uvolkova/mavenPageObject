package mantis.tests;

import mantis.pages.MantisSite;
import mantis.pages.ReportIssuePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportIssueTests extends BaseTest {

    private MantisSite mantisSite;

    @Test
    public void checkNewIssue() {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        mantisSite.getMainPage().goToReportIssuePage();
        String actualSummary = mantisSite.getReportIssuePage().summary("Summary_18");
        String actualDescription = mantisSite.getReportIssuePage().description("Description_18");
        mantisSite.getReportIssuePage().submitIssue();

        WebDriverWait wait = new WebDriverWait(driver, 30, 500);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("table#buglist tr:first-child>td.column-id")));

        String actualIdIssue = mantisSite.getReportIssuePage().getIssueId();
        mantisSite.getReportIssuePage().isIssueId();


        String actualIdViewIssuesDetails = mantisSite.getReportIssuePage().getIdViewIssueDetails();
        String actualDescriptionViewIssuesDetails = mantisSite.getReportIssuePage().getDescriptionViewIssuesDetails();


        Assertions.assertEquals(actualIdIssue, actualIdViewIssuesDetails);
        Assertions.assertEquals(actualDescription, actualDescriptionViewIssuesDetails);

        mantisSite.getReportIssuePage().deleteIssueButton();

        String actualSummaryDeleteIssues = mantisSite.getReportIssuePage().getSummaryDeleteIssues();
        String actualIdDeleteIssues = mantisSite.getReportIssuePage().getIdDeleteIssues();

        Assertions.assertEquals(actualIdViewIssuesDetails, actualIdDeleteIssues);
        Assertions.assertEquals(actualSummary, actualSummaryDeleteIssues);

        mantisSite.getReportIssuePage().lastDeleteIssues();

        Assertions.assertFalse(Boolean.parseBoolean(actualIdIssue));

    }


}
