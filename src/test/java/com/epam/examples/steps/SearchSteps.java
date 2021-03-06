package com.epam.examples.steps;

import static org.junit.Assert.assertTrue;
import com.epam.tests.pages.PageFactory;
import com.epam.tests.pages.SearchPage;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SearchSteps {

    private final PageFactory pages;
    private SearchPage searchPage;

    public SearchSteps(PageFactory pages) {
        this.pages = pages;
    }

    @BeforeScenario
    public void setupPages() {
        searchPage = pages.newSearchPage();
    }

    @Given("I am on search page")
    public void openSearchPage() {
        searchPage.open();
    }

    @When("Enter the value in Search field $value")
    public void setSearchParameters(String value) {
        searchPage.typeSearchParameters(value);
    }

    @When("click on search button")
    public void clickButtonSearch() {
        searchPage.clickSearchButton();
    }

    @Then("verify the search results")
    public void verifySearchResultShown() {
        assertTrue(searchPage.verifySearchResults());
    }

    @Then("verify the message")
    public void messageIsShown() {
        assertTrue(searchPage.verifyEmptySearchMessage());
    }
    
    @Then("verify the first link is exists")
    public void verifyFirstResult(){
    	assertTrue(searchPage.verifyFirstResult());
    }
    
    @Then("click on the first link")
    public void clickFirstResultButton()
    {
    	searchPage.clickFirstResultButton();
    }
    
    @Then("verify the url of the page")
    public void verifyURL()
    {
    	assertTrue(searchPage.verifyURL());
    }
}
