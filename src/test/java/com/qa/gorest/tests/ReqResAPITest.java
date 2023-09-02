package com.qa.gorest.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;

public class ReqResAPITest extends BaseTest{
	
	@BeforeMethod
	public void getUserSetup() {
		restClient = new RestClient(prop, baseURI);
		
	}
	@Test
	public void getReqRespTest() {
	 restClient.get(REQRES_ENDPOINT	+"/2", false, false)
	   .then().log().all()
	       .assertThat().statusCode(200);


}

}
