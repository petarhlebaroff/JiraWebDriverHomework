package test.cases.jira;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.jira.JiraIssuePage;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IssueTest extends BaseTest {


    @Test
    public void test1_createStorySuccessfully() throws InterruptedException {
        loginToDesiredProject(getUIMappingByKey("jira.projectInitials"));

        JiraIssuePage jiraIssuePage = new JiraIssuePage(actions.getDriver());
        jiraIssuePage.createStory();
        jiraIssuePage.assertIssueCreated();

        actions.waitForElementVisible("//button[@data-testid='platform.ui.flags.common.ui.common-flag-v2-dismiss']");
        actions.clickElement("//button[@data-testid='platform.ui.flags.common.ui.common-flag-v2-dismiss']");

//        jiraIssuePage.logOut();
    }


    @Test
    public void test2_createBugSuccessfully() {
//        loginToDesiredProject(getUIMappingByKey("jira.projectInitials"));

        JiraIssuePage jiraIssuePage = new JiraIssuePage(actions.getDriver());
        jiraIssuePage.createBug();
        jiraIssuePage.assertIssueCreated();

        actions.waitForElementVisible("//button[@data-testid='platform.ui.flags.common.ui.common-flag-v2-dismiss']");
        actions.clickElement("//button[@data-testid='platform.ui.flags.common.ui.common-flag-v2-dismiss']");

//        jiraIssuePage.logOut();
    }

//    @Test
//    public void test3_linkBugToStory() throws InterruptedException {
//
//        loginToDesiredProject(getUIMappingByKey("jira.projectInitials"));
//
//        JiraIssuePage jiraIssuePage = new JiraIssuePage(actions.getDriver());
//
//        jiraIssuePage.linkStoryToBug();
//
//        jiraIssuePage.assertIssueIsBlocked();
//
////        jiraIssuePage.logOut();
//
//    }
}
