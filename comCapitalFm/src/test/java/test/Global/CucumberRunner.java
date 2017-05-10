package test.Global;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by tusharjoge on 09/05/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@test", dryRun = false, features = ".")
public class CucumberRunner {
}
