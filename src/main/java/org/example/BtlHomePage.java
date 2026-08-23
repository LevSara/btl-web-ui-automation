package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BtlHomePage extends BasePage {
    private static final By SEARCH_INPUT = By.id("TopQuestions");
    private static final By SEARCH_BUTTON = By.id("ctl00_SiteHeader_reserve_btnSearch");

    private static final By BRANCHES_LINK = By.id("ctl00_Topmneu_BranchesHyperLink");

    public BtlHomePage(WebDriver driver) {
        super(driver);
    }

    public BtlHomePage open(String baseUrl) {
        driver.get(baseUrl);
        return this;
    }

    public BtlHomePage openMainMenu(MenuItems menuItem) {
        click(By.linkText(menuItem.getDisplayName()));
        return this;
    }

    public BtlHomePage openSubMenu(String subMenuText) {
        click(By.linkText(subMenuText));
        return this;
    }

    public BtlHomePage searchFor(String searchTerm) {
        type(SEARCH_INPUT, searchTerm);
        click(SEARCH_BUTTON);
        return this;
    }

    public BranchesPage openBranches() {
        click(BRANCHES_LINK);
        return new BranchesPage(driver);
    }
}
