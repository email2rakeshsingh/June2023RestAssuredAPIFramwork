package com.qa.gorest.utils;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.qa.gorest.framworksexception.APIFreameworkExeption;

import io.restassured.response.Response;
import java.util.List;
import java.util.Map;

public class JsonPathValidator {
	
	private String getjsonResponceAsString(Response response) {
		return response.getBody().asString();
	}

    public <T> T read(Response response, String jsonPath) {
        String	jsonResponse= getjsonResponceAsString(response );

        try {
            return JsonPath.read(jsonResponse, jsonPath);
        } catch (PathNotFoundException e) {
            e.printStackTrace();
            throw new APIFreameworkExeption(jsonPath + " is not found...");
        }
    }

    public <T> List<T> readList(Response response, String jsonPath) {
    	String	jsonResponse= getjsonResponceAsString(response );

        try {
            return JsonPath.read(jsonResponse, jsonPath);
        } catch (PathNotFoundException e) {
            e.printStackTrace();
            throw new APIFreameworkExeption(jsonPath + " is not found...");
        }
    }
    
    public <T> List<Map<String , T>> readListofMap(Response response, String jsonPath) {
    	String	jsonResponse= getjsonResponceAsString(response );

        try {
            return JsonPath.read(jsonResponse, jsonPath);
        } catch (PathNotFoundException e) {
            e.printStackTrace();
            throw new APIFreameworkExeption(jsonPath + " is not found...");
        }
    }
}

