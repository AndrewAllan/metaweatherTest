package BBC.Weather;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="E:/Development/BBC/Weather/src/feature/",
		tags = "@Automation"
		)
public class TestRun {

}
