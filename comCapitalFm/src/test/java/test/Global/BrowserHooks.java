package test.Global;

import cucumber.api.java.After;
import cucumber.api.java.Before;


import java.io.IOException;

/**
 * Created by tusharjoge on 09/05/2017.
 */
public class BrowserHooks {

    MainConfig mainConfig = new MainConfig();


    @Before
    public void setup() throws IOException {
        mainConfig.openBrowser();
    }

    @After
    public void tearDown() {
        mainConfig.closeBrowser();
    }
}
