package YahooAutomation.steps;

import YahooAutomation.references.Main;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.firefox.FirefoxProfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import java.security.PrivateKey;
import java.sql.Driver;


/**
 * Created by daniel.ingram on 22/01/2016.
 */

public class HomePageSteps {

    private Main main;


    // PicoContainer injects class Main
    public HomePageSteps(Main main) {
        this.main = main;
    }

    @Before
    public void startlogin()
    {

        main.StartBrowser();

    }

    @After
    public void stop() {
        main.StopBrowser();
    }


    @Given("^I am on the Yahoo Home Page$")
    public void iAmOnTheYahooHomePage() throws Throwable {
       main.WebDriver().get("https://uk.yahoo.com/");
    }

    @When("^I enter \"([^\"]*)\" in the search bar$")
    public void iEnterInTheSearchBar(String arg0) throws Throwable {
     main.homePage().EnterSearchCriteria(arg0);
    }

    @And("^I click the Search Web button$")
    public void iClickTheSearchWebButton() throws Throwable {
        main.homePage().ClickSearchButton();
    }

    @Then("^I should see results relating to Daniel Ingram$")
    public void iShouldSeeResultsRelatingToDanielIngram() throws Throwable {
        Document doc = Jsoup.parse(main.WebDriver().getPageSource());
        assertThat(main.WebDriver().getTitle(), containsString("Daniel Ingram - Yahoo Search Results"));
    }


    @Given("^I am on the Daniel Ingram results page$")
    public void iAmOnTheDanielIngramResultsPage() throws Throwable {
        main.WebDriver().get("https://uk.search.yahoo.com/search?p=Daniel+Ingram&fr=yfp-t-424");
    }

    @When("^I click the Wikipedia result$")
    public void iClickTheWikipediaResult() throws Throwable {
        main.homePage().clickSearchResult();
    }

    @Then("^I should see the Daniel Ingram Wikipedia page$")
    public void iShouldSeeTheDanielIngramWikipediaPage() throws Throwable {
        main.WebDriver().get("Daniel Ingram - Wikipedia, the free encyclopedia");
    }

}



