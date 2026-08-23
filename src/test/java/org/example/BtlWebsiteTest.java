package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BtlWebsiteTest {
    private WebDriver driver;
    private BtlHomePage homePage;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(System.getProperty("browser.headless", "true"))) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1920,1080", "--disable-notifications");

        driver = new ChromeDriver(options);
        homePage = new BtlHomePage(driver)
                .open(System.getProperty("base.url", "https://www.btl.gov.il"));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void opensBranchesFromMainMenu() {
        homePage.openMainMenu(MenuItems.BRANCHES);

        assertTrue(homePage.titleContains("סניפים וערוצי שירות"),
                "The branches page title should be displayed");
    }

    @Test
    void searchesTheWebsite() {
        homePage.searchFor("חישוב סכום דמי לידה ליום");

        assertTrue(homePage.titleContains("חישוב סכום דמי לידה ליום"),
                "The search results title should contain the search term");
    }

    @Test
    void findsBranchDetailsByCity() {
        BranchesPage branchesPage = homePage.openBranches().searchByCity("אשדוד");

        assertAll(
                () -> assertTrue(branchesPage.pageContains("מענה טלפוני")),
                () -> assertTrue(branchesPage.pageContains("קבלת קהל")),
                () -> assertTrue(branchesPage.pageContains("כתובת"))
        );
    }
}
