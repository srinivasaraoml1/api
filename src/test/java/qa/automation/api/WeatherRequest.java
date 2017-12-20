package qa.automation.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class WeatherRequest {

	public static String valid_api_key = "f7c2f9a273e120841ee074063fd90871";
	public static String invalid_api_key = "asdgvsdbfhfddfvc";
	
	// Request by City
	@Test(priority = 1)
	public void Request1() {
		Response p = get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid="+valid_api_key);
		System.out.println(p.getStatusCode());
		Assert.assertEquals(p.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void Request2() {
		Response p = get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid="+ invalid_api_key);
		System.out.println(p.getStatusCode());
		Assert.assertEquals(p.getStatusCode(), 401);
	}
}
