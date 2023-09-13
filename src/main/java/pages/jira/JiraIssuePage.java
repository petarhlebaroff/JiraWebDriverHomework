package pages.jira;

import junit.framework.TestResult;
import org.openqa.selenium.*;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;
import static com.telerikacademy.testframework.Utils.getWebDriver;
import static org.openqa.selenium.Keys.BACK_SPACE;
import static org.openqa.selenium.Keys.ENTER;

public class JiraIssuePage extends BaseJiraPage {

    public static String storyInitials;
    public static String bugInitials;

    public JiraIssuePage(WebDriver driver) {
        super(driver, "jira.loginPage");
    }

    public void assertLoginToProjectSuccessful() {
        actions.waitForElementPresent("jira.issuePage.projectNameLocator",
                getUIMappingByKey("jira.projectName"));
    }

    public void logOut() {
        actions.waitForElementPresent("jira.issuePage.profileAndSettingsButton");
        actions.clickElement("jira.issuePage.profileAndSettingsButton");

        actions.waitForElementPresent("jira.issuePage.dropDownSignOutButton");
        actions.clickElement("jira.issuePage.dropDownSignOutButton");

        actions.waitForElementPresent("jira.issuePage.signOutButton");
        actions.clickElement("jira.issuePage.signOutButton");

    }

    public void createStory(){

        actions.waitForElementVisible("jira.createIssueButton");
        actions.clickElement("jira.createIssueButton");

        actions.waitForElementVisible("jira.createIssueBox.Summary");
        actions.typeValueInField(getUIMappingByKey("jira.createIssueBox.summaryStoryText"), "jira.createIssueBox.Summary");

        actions.waitForElementVisible("jira.createIssueBox.issueType");
        actions.clickElement("jira.createIssueBox.issueType");
        actions.typeValueInField("Story", "jira.createIssueBox.issueTypeInput");
        actions.pressKey(ENTER);

        actions.waitForElementVisible("jira.createIssueBox.Priority");
        actions.clickElement("jira.createIssueBox.Priority");
        actions.typeValueInField("Highest","jira.createIssueBox.PriorityInput");
        actions.pressKey(ENTER);

        actions.waitForElementVisible("jira.createIssueBox.description");
        actions.typeValueInField("", "jira.createIssueBox.description");

        for (int i = 0; i < 85; i++) {
            actions.pressKey(BACK_SPACE);
        }

        actions.waitForElementVisible("jira.createIssueBox.description");
        actions.typeValueInField(getUIMappingByKey("jira.story.descriptionStoryText"), "jira.createIssueBox.description");

        actions.waitForElementPresent("jira.createIssueBox.createButton");
        actions.clickElement("jira.createIssueBox.createButton");

        actions.waitForElementVisible("jira.createIssue.successMessage");
        WebElement storyCreated = getWebDriver().findElement(By.xpath("//div[@data-testid='platform.ui.flags.common.ui.common-flag-v2']"));
        storyInitials = storyCreated.getText().substring(16, 23);
        System.out.println(storyInitials);

    }
    public void createBug(){

        actions.waitForElementVisible("jira.createIssueButton");
        actions.clickElement("jira.createIssueButton");

        actions.waitForElementVisible("jira.createIssueBox.Summary");
        actions.typeValueInField(getUIMappingByKey("jira.createIssueBox.summaryBugText"), "jira.createIssueBox.Summary");

        actions.waitForElementVisible("jira.createIssueBox.issueType");
        actions.clickElement("jira.createIssueBox.issueType");
        actions.typeValueInField("Bug", "jira.createIssueBox.issueTypeInput");
        actions.pressKey(ENTER);

        actions.waitForElementVisible("jira.createIssueBox.Priority");
        actions.clickElement("jira.createIssueBox.Priority");
        actions.typeValueInField("Highest","jira.createIssueBox.PriorityInput");
        actions.pressKey(ENTER);

        actions.waitForElementVisible("jira.createIssueBox.description");
        actions.typeValueInField("", "jira.createIssueBox.description");

        for (int i = 0; i < 85; i++) {
            actions.pressKey(BACK_SPACE);
        }

        actions.waitForElementVisible("jira.createIssueBox.description");
        actions.typeValueInField(getUIMappingByKey("jira.story.descriptionBugText"), "jira.createIssueBox.description");

        actions.waitForElementPresent("jira.createIssueBox.createButton");
        actions.clickElement("jira.createIssueBox.createButton");

        actions.waitForElementVisible("jira.createIssue.successMessage");
        WebElement bugCreated = getWebDriver().findElement(By.xpath("//div[@data-testid='platform.ui.flags.common.ui.common-flag-v2']"));
        bugInitials = bugCreated.getText().substring(16, 23);
        System.out.println(bugInitials);

    }

    public void assertIssueCreated() {
        actions.waitForElementVisible("jira.createIssue.successMessage");
        actions.waitForElementVisible("//button[@data-testid='platform.ui.flags.common.ui.common-flag-v2-dismiss']");
        actions.clickElement("//button[@data-testid='platform.ui.flags.common.ui.common-flag-v2-dismiss']");
    }

    public void linkStoryToBug() throws InterruptedException {


        actions.waitForElementVisible("//button[@data-testid='issue-navigator.common.ui.refresh-button.refresh-button']");
        actions.clickElement("//button[@data-testid='issue-navigator.common.ui.refresh-button.refresh-button']");

        Thread.sleep(3000);

        actions.waitForElementVisible("//p[@class='_11127mnp _1q091wmp _pytkt94y _5hv9t94y _2x4g1n1a _12hv1n1a _x5bd1n1a _1rgf1n1a _1yzy15vq _bgrh15vq _v69yidpf _ogxmidpf _1qtqidpf _n9z4idpf _khufstnw _15pj1ule _d7ff1l7b _1j8614y2 _1qrc1l7b _4yng14y2 _1vzltlke _1ioh1l7b _vrjh14ae _1hhy73ad _1emz73ad _1efl8q0r _c2fy18uv _ynfu18uv _7el91vt6 _15pqglyw'][descendant::text()='List view']");
        actions.clickElement("//p[@class='_11127mnp _1q091wmp _pytkt94y _5hv9t94y _2x4g1n1a _12hv1n1a _x5bd1n1a _1rgf1n1a _1yzy15vq _bgrh15vq _v69yidpf _ogxmidpf _1qtqidpf _n9z4idpf _khufstnw _15pj1ule _d7ff1l7b _1j8614y2 _1qrc1l7b _4yng14y2 _1vzltlke _1ioh1l7b _vrjh14ae _1hhy73ad _1emz73ad _1efl8q0r _c2fy18uv _ynfu18uv _7el91vt6 _15pqglyw'][descendant::text()='List view']");

        actions.waitForElementVisible("jira.findIssueByInitials.Locator", storyInitials);
        actions.clickElement("jira.findIssueByInitials.Locator", storyInitials);


        actions.waitForElementClickable("jira.linkButton");
        actions.clickElement("jira.linkButton");


        actions.waitForElementClickable("jira.linkIssueButton");
        actions.clickElement("jira.linkIssueButton");


        actions.waitForElementVisible("//div[@class='issue-links-search__input']/input");

        actions.typeValueInField(bugInitials, "//div[@class='issue-links-search__input']/input");

        actions.pressKey(ENTER);


        WebElement searchBox = getWebDriver().findElement(By.xpath("//div[@class='issue-links-search__input']/input"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);


        actions.waitForElementVisible("jira.finalLinkButton");
        actions.clickElement("jira.finalLinkButton");

    }

    public void assertIssueIsBlocked(){
        actions.waitForElementVisible("jira.issueIsBlockedContainer");
    }

}
