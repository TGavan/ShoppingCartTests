package com.powerdiary.webtests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {

    private WebDriver driver;

    @FindBy(css = "h1.page-title>span")
    private WebElement wishListPageTitleText;

    @FindBy(css = "p.toolbar-amount")
    private WebElement wishListItemsCounter;


    public WishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isWishListPageTitleIsDisplayed() {
        if (wishListPageTitleText.isDisplayed()) {
            return true;
        } else
            return false;
    }

    public boolean isWishListItemCounterDisplayed() {
        if (wishListItemsCounter.isDisplayed()) {
            return true;
        } else
            return false;
    }
}
