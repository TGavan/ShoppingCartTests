package com.powerdiary.webtests.pageobjects;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductDetailsPage {

    private WebDriver driver;

    @FindBy(css = "button#product-addtocart-button")
    private WebElement addToCartButton;

    @FindBy(css = "div.product-social-links>div>a")
    private List<WebElement> addToWishListIcon;


    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProductDetailsPageIsDisplayed() {
        if (addToCartButton.isDisplayed()) {
            return true;
        } else
            return false;
    }

    public WishListPage userClicksOnTheWishListLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addToWishListIcon.get(0)));
        addToWishListIcon.get(0).click();
        return new WishListPage(driver);
    }
}
