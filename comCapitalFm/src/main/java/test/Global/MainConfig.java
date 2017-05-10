package test.Global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by tusharjoge on 09/05/2017.
 */
public class MainConfig {

    public static WebDriver getDriver;


    public MainConfig() {
        PageFactory.initElements(getDriver, this);
    }

    public void openBrowser() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resouces/config.properties");
        properties.load(fileInputStream);

        System.setProperty(("user.dir") + "webdriver.gecko.getdriver", "geckodriver");
        System.setProperty(("user.dir") + "webdriver.chromedriver.getdriver", "chromedriver");

        String url = properties.getProperty("url");
        String browser = properties.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            getDriver = new ChromeDriver();
            System.out.println("\n");
            System.out.println("Chrome Browser Invoked");
            System.out.println("\n");
        } else if (browser.equalsIgnoreCase("firefox")) {
            getDriver = new FirefoxDriver();
            System.out.println("\n");
            System.out.println("FireFox Browser Invoked");
            System.out.println("\n");

        } else {
            System.out.println("\n");
            System.out.println("Browser Invocation failed");
            System.out.println("\n");

        }

        getDriver.get(url);
        getDriver.manage().window().maximize();
        getDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public void closeBrowser() {
        getDriver.quit();
    }
}
