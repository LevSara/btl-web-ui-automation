package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BranchesPage extends BasePage {
    private static final By CITY_SELECTOR = By.id("select2-YshuvMegurim-container");
    private static final By CITY_SEARCH = By.cssSelector("input.select2-search__field");

    public BranchesPage(WebDriver driver) {
        super(driver);
    }

    public BranchesPage searchByCity(String city) {
        click(CITY_SELECTOR);
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(CITY_SEARCH));
        searchInput.sendKeys(city, Keys.ENTER);
        return this;
    }
}
