package com.powerdiary.webtests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = "input#search")
    private WebElement searchTextBox;

    @FindBy(css = "button.action.search")
    private WebElement searchIcon;

    @FindBy(css = "li#qs-option-0")
    private WebElement firstAutosuggestion;

    @FindBy(css = "a.product-item-photo")
    private List<WebElement> availableProductsOnHomePage;

    @FindBy(css = "li.authorization-link>a")
    private WebElement signInLink;

    @FindBy(css = "a#ui-id-3")
    private WebElement whatsNewLinkOnHomePage;

    @FindBy(css = "a.action.details")
    private WebElement wishListLinkOnHomePage;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage navigateToShoppingCartHomePage() {
        driver.get("https://magento.softwaretestingboard.com/");
        return new HomePage(driver);
    }

    public HomePage userEntersSearchText(String searchText) {
        searchTextBox.sendKeys(searchText);
        return new HomePage(driver);
    }

    public SearchResultsPage userClicksSearchIcon() {
        Actions action = new Actions(driver);
        action.moveToElement(searchIcon).click().build().perform();
        searchIcon.click();
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage clickFirstAutosuggestion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstAutosuggestion));
        firstAutosuggestion.click();
        return new SearchResultsPage(driver);
    }

    public LoginPage userClicksOnSingInLink() {
        signInLink.click();
        return new LoginPage(driver);
    }

    public boolean isUserOnHomePage() {

        if (whatsNewLinkOnHomePage.isDisplayed()) {
            return true;
        } else
            return false;
    }

    public void userNavigatesToWishListSection() {
        whatsNewLinkOnHomePage.click();
        wishListLinkOnHomePage.click();
    }

    public ProductDetailsPage userClicksOnTheFirstProductImageOnHomePage() {
        availableProductsOnHomePage.get(0).click();
        System.out.println("click is now done");
        return new ProductDetailsPage(driver);
    }
}
