package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "html:target/cucumber-reports.html",
		features = "src/test/resources/features" ,
		glue = "stepdefinitions" ,
		tags = "@wip" ,
		dryRun = false //true olduğunda  sadece eksik adımları verir ve buradan koyalayıp yazabiliriz.
)

public class Runner {

}
