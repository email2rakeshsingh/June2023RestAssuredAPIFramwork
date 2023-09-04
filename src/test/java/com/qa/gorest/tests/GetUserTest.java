package com.qa.gorest.tests;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.constants.APIHttpStatus;

import io.qameta.allure.Description;

public class GetUserTest extends BaseTest {

	@BeforeMethod
	public void getUserSetup() {
		restClient = new RestClient(prop, baseURI);

	}

	@Description("this test is in progress")
	@Test(enabled = true)
	public void getAllUserTest() {
		// Perform a GET request to the specified endpoint
		restClient.get(GOREST_ENDPOINT, true, true).then().log().all().assertThat()
				.statusCode(APIHttpStatus.OK_200.getCode());
	}

	@Test()
	public void getUserTest() {
		restClient.get(GOREST_ENDPOINT + "/" + 4990573, true, true).then().log().all().assertThat()
				.statusCode(APIHttpStatus.OK_200.getCode()).and().body("id", equalTo(4990573));
	}

	@Test()
	public void getUserWithQueryParamsTest() {

		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("name ", "Rakesh");
		queryParams.put("status", "active");

		// Perform a GET request with query parameters and validate the response
		restClient.get(GOREST_ENDPOINT, queryParams, true, true).then().log().all().assertThat()
				.statusCode(APIHttpStatus.OK_200.getCode());
	}

}
