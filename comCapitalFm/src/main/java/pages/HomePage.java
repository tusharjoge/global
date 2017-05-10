package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.Global.MainConfig;

import java.util.List;

/**
 * Created by tusharjoge on 10/05/2017.
 */
public class HomePage extends MainConfig {

    @FindBy(css = "div[id=\"nav_wrapper\"] li em")
    private List<WebElement> namesOfPages;

    @FindBy(css = "div[class='track__track-info'] h2")
    private WebElement playStatusOnHomePage;

    @FindBy(css = "div[class='track__text-content'] div[class='track__track-info'] div[itemprop='byArtist']")
    private WebElement nameAppearsIfNowPlaying;

    @FindBy(css = "div[class='now_playing_card__subtitle'] a[class='see_more']")
    private WebElement seeMorelink;

    public boolean checkCurrentPage(String pageStatus) {
        boolean page = false;
        for (WebElement pageName : namesOfPages) {
            if (pageName != null)
                if (pageName.getAttribute("innerHTML").contains(pageStatus)) {
                    pageName.click();
                    if (pageName.getCssValue("color").equals("rgba(0, 175, 215, 1)")) ;
                    page = true;
                    System.out.println("Now I am on" + pageStatus + "Page");
                    System.out.println("\n");
                }
        }
        return page;
    }

    public boolean checkWhatIsOnPage(String currentlyPlaying, String recentPlay) {
        boolean result = false;

        if (playStatusOnHomePage != null)
            if (playStatusOnHomePage.getText().equalsIgnoreCase(currentlyPlaying) && !playStatusOnHomePage.getText().equalsIgnoreCase(recentPlay)) {
                System.out.println("\n");
                System.out.println("Currently -->" + currentlyPlaying + " is seen on Home Page ");
                System.out.println("\n");
                result = true;
            } else {
                playStatusOnHomePage.getText().contains(recentPlay);
                System.out.println("\n");
                System.out.println("At present  --> (" + recentPlay + ") is seen on Home Page ");
                System.out.println("\n");
                result = true;

            }

        return result;
    }

    public boolean checkArtistIfPlaying(String nameOfArtist) {
        boolean result = false;
        if (playStatusOnHomePage != null)
            if (playStatusOnHomePage.getText().contains("NOW PLAYING")) {
                result = true;
                System.out.println("The music track is currently Playing let us check Which Artist is singing");
                if (nameAppearsIfNowPlaying != null) {
                    result = true;
                    System.out.println("The Current Artist playing music is " + nameAppearsIfNowPlaying.getText().trim());
                    if (nameAppearsIfNowPlaying.getText().trim().contains(nameOfArtist)) {
                        System.out.println(nameAppearsIfNowPlaying.getText().trim());
                        result = true;

                    } else {
                        System.out.println("The current Artist is not Justin Beiber");
                        result = false;
                    }
                } else {
                    System.out.println("CURRENTLY THERE IS NOT TRACK PLAYING");
                    result = false;
                }
            } else {
                System.out.println("RECENTLY PLAYED text is seen try when NOW PLAYING is visible");
                result = false;
            }
        return result;
    }

    public void clickLink(String linkName) {
        if (seeMorelink.isEnabled()) {
            ((JavascriptExecutor) getDriver).executeScript("arguments[0].scrollIntoView(true);", seeMorelink);
            seeMorelink.click();
        }
    }

}
