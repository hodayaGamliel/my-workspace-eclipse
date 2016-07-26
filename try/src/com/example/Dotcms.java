package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Dotcms {

	public static void main(String[] args) throws IOException 
	{
		String urlStr = "http://52.23.185.166:8080/api" ;
		httpGet(urlStr);
	}

	public static String httpGet(String urlStr) throws IOException {
		  URL url = new URL(urlStr);
		  HttpURLConnection conn =
		      (HttpURLConnection) url.openConnection();

		  if (conn.getResponseCode() != 200) {
		    throw new IOException(conn.getResponseMessage());
		  }

			 // Buffer the result into a string
			 BufferedReader rd = new BufferedReader(
			     new InputStreamReader(conn.getInputStream()));
			 StringBuilder sb = new StringBuilder();
			 String line;
			  while ((line = rd.readLine()) != null) {
			    sb.append(line);
			  }
			  rd.close();

			  conn.disconnect();
			  return sb.toString();
			}
			
}
