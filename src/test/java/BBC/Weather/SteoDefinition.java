package BBC.Weather;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SteoDefinition {

	public Response res;
	private Response response;
    private String BaseURL = "https://www.metaweather.com/api/location/"; 
    static Logger log = LogManager.getLogger(SteoDefinition.class);
	
	@Given("^the Location endpoint is up$")
	public void the_Location_endpoint_is_up() throws Throwable {
		response = get(BaseURL+"44418/");
		response.then().assertThat().statusCode(200);		
	}
	
	@When("^A location is sent to the Api$")
	public void A_location_woeid_is_sent_to_the_Api() throws Throwable {
		//sending the woeid for london = 44418
		log.info("Sending the woeid for london to the api");
		response = get(BaseURL+"44418/");
	}

	@Then("^weather information for today is returned$")
	public void weather_information_for_today_is_returned() throws Throwable {
		//checking that the weather for today matches the expected from assessment form Heavy Cloud	
		log.info("asserting the weather for today matches expected");
		response.then().assertThat().body("consolidated_weather.find { it.applicable_date == '"+ Utils.FormatedDate("yyyy-MM-dd",0)+"'}.weather_state_name", equalTo("Heavy Cloud"));
	}
	
	@And("^weather information for tomorrow is returned$")
	public void weather_information_for_tomorrow_is_returned() throws Throwable {		
		log.info("asserting the weather for tomorow matches expected");
		response.then().assertThat().body("consolidated_weather.find { it.applicable_date == '"+ Utils.FormatedDate("yyyy-MM-dd",1)+"'}.weather_state_name", equalTo("Showers"));
	}
	
	@And("^weather information for tomorrow plus1 is returned$")
	public void weather_information_for_tomorrow_plus1_is_returned() throws Throwable {		
		log.info("asserting the weather for the day after tomorow matches expected");
		response.then().assertThat().body("consolidated_weather.find { it.applicable_date == '"+ Utils.FormatedDate("yyyy-MM-dd",2)+"'}.weather_state_name", equalTo("Clear"));
	}
	
	@And("^weather information for tomorrow plus2 is returned$")
	public void weather_information_for_tomorrow_plus2_is_returned() throws Throwable {		
		log.info("asserting the weather for tomorow + 2  matches expected");
		response.then().assertThat().body("consolidated_weather.find { it.applicable_date == '"+ Utils.FormatedDate("yyyy-MM-dd",3)+"'}.weather_state_name", equalTo("Light Cloud"));
	}
	
	@When("^A location and todays date is sent to the location endpoint$")
	public void A_location_and_todays_date_is_sent_to_the_Api() throws Throwable {
		log.info("sending the location woeid for london plus the date for today");
		response = get(BaseURL+"44418/"+ Utils.FormatedDate("yyyy/MM/dd", 0));
	}

	@When("^Weather data for today is retruned$")
	public void Weather_data_for_today_is_retruned() throws Throwable {
		//after investigation the top element returned appears to have the same id as the current day returned in the 5 day weather forcast 
		log.info("asserting the weather for today matches expected");
		response.then().assertThat().body("weather_state_name[0]", equalTo("Heavy Cloud"));	
		}
	
}
