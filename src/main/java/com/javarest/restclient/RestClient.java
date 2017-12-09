package com.javarest.restclient;

import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.codehaus.jettison.json.JSONArray;

public class RestClient {
	private String url;
	
	public RestClient(String url)
	{
		this.url = url;
	}
	
	/**
	 * Returns JSONObject from an API callback
	 * @return
	 */
	public JSONObject getJsonObject()
	{
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource webResource = client.resource(url);
        JSONObject response = webResource.type("application/json").get(JSONObject.class);
        return response;
	}
	
	/**
	 * Returns JSONArray from a JsonObject
	 * @param jsonObject
	 * @param jsonArray
	 * @return
	 */
	public JSONArray getJsonArray(JSONObject jsonObject, String jsonArray) 
	{
		try
		{
			return jsonObject.getJSONArray(jsonArray);
		}
		catch(Exception e)
		{
			System.out.println("Unnable to get JsonArray from JsonObject");
			return null;
		}
	}

}
