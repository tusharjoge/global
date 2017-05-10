package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.FindBy;
import test.Global.MainConfig;

import javax.swing.*;
import java.util.List;

/**
 * Created by tusharjoge on 10/05/2017.
 */
public class RadioPage extends MainConfig {
    HomePage homePage = new HomePage();

    @FindBy(css = "div[id='contextual_nav_wrapper'] h1")
    private WebElement h1TitleOfPage;

    @FindBy(css = "div[id*='song_promo'] h3 span[itemprop='byArtist']")
    private WebElement parentPageNameOnSubPage;

    @FindBy(css = "div[id*='song_promo'] h3 a[href*='/artists/']")
    private List<WebElement> listOfRecentlyPlayedTracks;

    public boolean checkIfIamOnCorrectPage(String subPage, String parentPage) {

        boolean result = false;
        if (h1TitleOfPage != null)
            if (h1TitleOfPage.getText().trim().contains(subPage))
                if (parentPageNameOnSubPage.getText().trim().contains(parentPage)) {
                    result = true;
                }
        return result;
    }

    public void checkNumberOfPages() {
        System.out.println("Total tracks played recently are --> " + listOfRecentlyPlayedTracks.size());
    }

    public boolean recentPlayedSongsArtistWise(String artistName) {
        boolean artist = false;
        Actions actions = new Actions(getDriver);

        for (WebElement nameOfArtist : listOfRecentlyPlayedTracks) {
            if (listOfRecentlyPlayedTracks != null)
                if (!nameOfArtist.isDisplayed()) {
                    try {
                        dismissAlerts();
                    } catch (Exception e) {

                    }
                    if (nameOfArtist.getAttribute("innerHTML").trim().equalsIgnoreCase(artistName)) {
                        actions.moveToElement(nameOfArtist).build().perform();
                        artist = true;
                        System.out.println(nameOfArtist.getText().trim().equalsIgnoreCase(artistName));
                        continue;
                    }
                }
        }
        return artist;
    }

    public void dismissAlerts() {
        Alert alert = getDriver.switchTo().alert();
        alert.dismiss();
    }
}
