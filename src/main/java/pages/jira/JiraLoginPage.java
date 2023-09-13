package pages.jira;

import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;

public class JiraLoginPage extends BaseJiraPage{
    public JiraLoginPage(WebDriver driver) {
        super(driver, "jira.loginPage");
    }


    public void loginUser(String userKey, String project) {
        String username = getConfigPropertyByKey("jira.users." + userKey + ".username");
        String password = getConfigPropertyByKey("jira.users." + userKey + ".password");

        navigateToPage();
        assertPageNavigated();

        actions.waitForElementVisible("jira.loginPage.username");

        actions.typeValueInField(username, "jira.loginPage.username");
        actions.waitForElementVisible("jira.loginPage.continueButton");
        actions.clickElement("jira.loginPage.continueButton");

        actions.waitForElementClickable("jira.loginPage.logInButton");
        actions.waitForElementClickable("jira.loginPage.password");

        actions.typeValueInField(password, "jira.loginPage.password");
        actions.clickElement("jira.loginPage.logInButton");

        actions.waitForElementVisible("jira.startPage.jiraSoftware");
        actions.clickElement("jira.startPage.jiraSoftware");

        actions.waitForElementPresent("jira.startPage.clickOnProject", project);
        actions.clickElement("jira.startPage.clickOnProject", project);

        actions.waitForElementPresent("jira.createIssueButton");
    }
}
