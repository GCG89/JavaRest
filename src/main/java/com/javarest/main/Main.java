package com.javarest.main;

import com.javarest.restclient.RestClient;

public class Main {

	public static void main(String[] args) 
	{
		RestClient r = new RestClient("https://catfact.ninja/fact");
		
		try{
			System.out.println(r.getJsonObject().get("fact"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
