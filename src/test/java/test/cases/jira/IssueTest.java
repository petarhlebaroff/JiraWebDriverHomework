package test.cases.jira;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.jira.JiraIssuePage;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IssueTest extends BaseTest {

    private JiraIssuePage jiraIssuePage;

    @Before
            public void pagesSetup() {
        jiraIssuePage = new JiraIssuePage(actions.getDriver());
    }

    @Test
    public void test1_createStorySuccessfully() {
        loginToDesiredProject(getUIMappingByKey("jira.projectInitials"));

        jiraIssuePage.createStory();
        jiraIssuePage.assertIssueCreated();
    }


    @Test
    public void test2_createBugSuccessfully() {

        jiraIssuePage.createBug();
        jiraIssuePage.assertIssueCreated();
    }

    @Test
    public void test3_linkBugToStory() throws InterruptedException {

        jiraIssuePage.linkStoryToBug();
        jiraIssuePage.assertIssueIsBlocked();

    }
}