package YahooAutomation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by daniel.ingram on 20/01/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources", format = { "pretty",
        "html:target/site/cucumber-pretty",
        "json:target/cucumber.json" },
        glue ={"YahooAutomation"},
        //tags = { "@Duplicatematch" }
        // tags = { "@NewApplication" }
        //tags={"@AutoEditApplication"}
        //tags={" @ManualEditApplication"}
        // tags = {"@Addcall"}
        tags={"@Test"}

)



public class CukesRunner {
}
