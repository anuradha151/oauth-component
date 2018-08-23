package com.anuradha.demo.util;



import com.anuradha.demo.exception.JerseyException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient {
    private String endPoint;
    private String token;

    public RestClient(String url) {
        this.endPoint = url;
    }

    public
    RestClient(String url, String token) {
        endPoint = url;
        this.token = token;
    }

    public String getResponse() {
        String response = "";
        try {
            URL url = new URL(endPoint);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "dbProperties/" + "json");
            httpURLConnection.setRequestProperty("Authorization", "Bearer " + token);

//            System.out.println("\n\ntoken : " + token+"\n");
//            System.out.println("\n\nResponse code : " + httpURLConnection.getResponseCode()+"\n\n");

            if (httpURLConnection.getResponseCode() != 200) {

                throw new JerseyException("Token has expired");
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String output = "";
            while ((output = bufferedReader.readLine()) != null) {
                response += output;
            }
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            throw new JerseyException(e.getMessage());
        }

//        System.out.println("\n\nresponse : "+response+"\n\n");
        return response;
    }

}
 