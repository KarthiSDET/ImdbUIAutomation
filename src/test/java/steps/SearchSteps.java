package steps;

import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.PageHandler;

public class SearchSteps extends PageHandler {

    SearchPage searchPage = new SearchPage();

    @Given("^User is in search page of Imdb website$")
    public void userSearchInImdb() {
        driverSetup();
        getDriver().get("https://www.imdb.com/");
    }

    @When("user enters {string} and clicks on search button")
    public void userEntersAndClicksOnSearchButton(String searchTerm) {
        searchPage.userEntersInSearchTextBox(searchTerm);
        searchPage.clickOnSearchBtn();
    }

    @Then("user should be navigated to {string} details page")
    public void userShouldBeNavigatedToDetailsPage(String searchTerm) {
        searchPage.clickOnDirectorNameInNameSection(searchTerm);
    }

    @And("user search for {string} directed movies")
    public void userSearchForDirectedMovies(String searchTerm) {
        searchPage.clickOnDirectorInDirectorDetailsPage();

    }

    @And("validate directed movies by {string}")
    public void validateDirectedMoviesBy(String searchTerm) {
        searchPage.getAllMovies(searchTerm);
        getDriver().quit();
    }
}
