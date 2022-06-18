package org.qa.tool.cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SearchSteps  {


    @Given("^I have the following books in the store$")
    public void givenBooks(DataTable dataTable) {

    }

    @When("^I search for books by author Erik Larson$")
    public void searchBooks() {

    }

    @Then("^I find 2 books$")
    public void verifyBookSearchResult() {

    }
}
