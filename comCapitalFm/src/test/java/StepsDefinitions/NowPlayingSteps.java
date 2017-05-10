package StepsDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.RadioPage;

/**
 * Created by tusharjoge on 09/05/2017.
 */
public class NowPlayingSteps {
    HomePage homePage = new HomePage();
    RadioPage radioPage = new RadioPage();

    @Given("^I am on \"([^\"]*)\" page$")
    public void i_am_on_page(String pageStatus) throws Throwable {
        Assert.assertTrue(homePage.checkCurrentPage(pageStatus));
    }

    @And("^I a find \"([^\"]*)\" or \"([^\"]*)\" on the page$")
    public void IAFindOrOnThePage(String currentPlaying, String recentlyPlayed) throws Throwable {
        Assert.assertTrue(homePage.checkWhatIsOnPage(currentPlaying, recentlyPlayed));
    }

    @And("^I check if \"([^\"]*)\" is now playing$")
    public void iCheckIfIsNowPlaying(String nameOfArtist) throws Throwable {
        Assert.assertTrue(homePage.checkArtistIfPlaying(nameOfArtist));
    }

    @When("^I click \"([^\"]*)\" on the page$")
    public void iClickOnThePage(String linkName) throws Throwable {
        homePage.clickLink(linkName);
    }

    @Then("^I should be on sub page \"([^\"]*)\" of \"([^\"]*)\" page\"$")
    public void iShouldSeeSubPageOfPage(String currentSubPageName, String parentPage) throws Throwable {
        Assert.assertTrue(radioPage.checkIfIamOnCorrectPage(currentSubPageName, parentPage));
    }

    @Then("^I should see all the music tracks on the page played on that day$")
    public void iShouldSeeAllTheMusicTracksOnThePagePlayedOnThatDay() throws Throwable {
        radioPage.checkNumberOfPages();
    }

    @And("^I should see tracks of \"([^\"]*)\" played$")
    public void iShouldSeeTracksOfPlayed(String artistName) throws Throwable {
        Assert.assertTrue(radioPage.recentPlayedSongsArtistWise(artistName));

    }
}
