package com.powerdiary.webtests.steps;

import com.powerdiary.webtests.pageobjects.HomePage;
import com.powerdiary.webtests.pageobjects.SearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SearchSteps {

    private Base base;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    public SearchSteps(Base base) {
        this.base = base;
        this.homePage = new HomePage(base.driver);
        this.searchResultsPage = new SearchResultsPage(base.driver);
    }

    @Given("The User navigates to the home page of the shopping portal")
    public void theUserNavigatesToTheHomePageOfTheShoppingPortal() {
        homePage.navigateToShoppingCartHomePage();
    }

    @And("The User inputs a valid {string} into the search bar")
    public void theUserInputsAValidIntoTheSearchBar(String sku) {
   /*This special way of entering the SKU is needed so that autosuggestions can be displayed*/

        for (int i = 0; i < sku.length(); i++) {
            homePage.userEntersSearchText(String.valueOf(sku.charAt(i)));
        }
    }

    @And("The User initiates the search by clicking on the search icon")
    public void theUserInitiatesTheSearchByClickingOnTheSearchIcon() {
        homePage.userClicksSearchIcon();
    }

    @Then("The User should observe the amount of the articles is displayed as search results")
    public void theUserShouldObserveTheAmountOfTheArticlesIsDisplayedAsSearchResults() {
        Assert.assertTrue(searchResultsPage.verifyAmountOfSearchedItem());
    }

    @And("The User inputs different invalid {string} into the search bar")
    public void theUserInputsDifferentInvalidIntoTheSearchBar(String invalidSku) {
        homePage.userEntersSearchText(invalidSku);
    }

    @Then("The User should observe the message for no search results displayed on the page")
    public void theUserShouldObserveTheMessageForNoSearchResultsDisplayedOnThePage() {
        Assert.assertTrue(searchResultsPage.verifyErrorMessageIsDisplayed());
    }

    @And("The User clicks on the first autosuggestion provided by the application")
    public void theUserClicksOnTheFirstAutosuggestionProvidedByTheApplication() {
        homePage.clickFirstAutosuggestion();
    }
}
