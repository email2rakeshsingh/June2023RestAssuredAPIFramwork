package com.qa.gorest.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.constants.APIHttpStatus;
import com.qa.gorest.utils.JsonPathValidator;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

import java.util.List;

public class CircuitTest extends BaseTest {

	private RestClient restClient;

	@BeforeMethod
	public void setUp() {
		restClient = new RestClient(prop, baseURI);
	}

	@Test
	public void testGetCircuitInfo() {
		Response circuitResponse = restClient.get(CIRCUIT_ENDPOINT + "/2017/circuits.json", false, false);
		circuitResponse
		    .then()
		       .assertThat()
		            .statusCode(APIHttpStatus.OK_200.getCode());
		           
	
		JsonPathValidator jsonPathValidator = new JsonPathValidator();
		List<String> countryList = jsonPathValidator.readList(circuitResponse,
				"$.MRData.CircuitTable.Circuits[?(@.circuitId == 'shanghai')].Location.country");

		System.out.println("Country: " + countryList.get(0));
		Assert.assertTrue(countryList.contains("China"));
	}
}
