package com.powerdiary.webtests.steps;

import com.powerdiary.webtests.pageobjects.HomePage;
import com.powerdiary.webtests.pageobjects.ProductDetailsPage;
import com.powerdiary.webtests.pageobjects.SearchResultsPage;
import com.powerdiary.webtests.pageobjects.WishListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class WishListSteps {

    private Base base;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ProductDetailsPage productDetailsPage;
    private WishListPage wishListPage;

    public WishListSteps(Base base) {
        this.base = base;
        this.homePage = new HomePage(base.driver);
        this.searchResultsPage = new SearchResultsPage(base.driver);
        this.productDetailsPage = new ProductDetailsPage(base.driver);
        this.wishListPage = new WishListPage(base.driver);
    }

    @And("The User clicks on SignIn link and enters valid credentials")
    public void theUserClicksOnSignInLinkAndEntersValidCredentials() {
        homePage.userClicksOnSingInLink().
                userLoginWithValidCredentials("gk2925@gmail.com", "Test1234");
    }

    @Then("The User is logged  in successfully")
    public void theUserIsLoggedInSuccessfully() {
        Assert.assertTrue(homePage.isUserOnHomePage());
    }

    @And("The User clicks on the first image of the product displayed on the home page")
    public void theUserClicksOnTheFirstImageOfTheProductDisplayedOnTheHomePage() {
        homePage.userClicksOnTheFirstProductImageOnHomePage();

    }

    @Then("The product details page is displayed")
    public void theProductDetailsPageIsDisplayed() {
        Assert.assertTrue(productDetailsPage.verifyProductDetailsPageIsDisplayed());
    }

    @Then("The user is landed to the WishList Page")
    public void theUserIsLandedToTheWishListPage() {
        Assert.assertTrue(wishListPage.isWishListPageTitleIsDisplayed());
    }

    @And("User can see the counter available for the items in this page")
    public void userCanSeeTheCounterAvailableForTheItemsInThisPage() {
        Assert.assertTrue(wishListPage.isWishListItemCounterDisplayed());
    }

    @And("User clicks on the Wish List link")
    public void userClicksOnTheWishListLink() {
        productDetailsPage.userClicksOnTheWishListLink();
    }
}
