package com.powerdiary.webtests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {

    private WebDriver driver;

    @FindBy(css = "p#toolbar-amount>span")
    private WebElement searchedItemAmount;

    @FindBy(css = "img.product-image-photo")
    private WebElement searchResultImage;

    @FindBy(css = "button[title='Add to Cart']")
    private WebElement searchResultsAddToCartButton;

    @FindBy(css = "button[title='Add to Wish List']")
    private WebElement searchResultAddToWishListIcon;

    @FindBy(css = "div.message.notice>div")
    private WebElement noResultsForSearchMessage;


    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyAmountOfSearchedItem() {
        if (Integer.parseInt(searchedItemAmount.getText()) > 0) {
            return true;
        } else
            return false;
    }

    public Boolean verifyErrorMessageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(noResultsForSearchMessage));
        if (noResultsForSearchMessage.isDisplayed()) {
            return true;
        } else
            return false;
    }
}
