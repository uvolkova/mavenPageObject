package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IssuesTests extends BaseTest{

    private MantisSite mantisSite;

    @Test
    public void checkIssuesNumber (){
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin","admin20");

        mantisSite.getMainPage().goToViewIssuesPage();
        int actualIssuesNumber = mantisSite.getVewIssuesPage().countIssues();

        Assertions.assertEquals(50,actualIssuesNumber);
    }

}
