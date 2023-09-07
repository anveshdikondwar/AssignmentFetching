package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        String url ="https://api.zippopotam.us/us/33162";
        URL ApiUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) ApiUrl.openConnection();
        int responseCode = conn.getResponseCode();
        if(responseCode==200){
            BufferedReader in =new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readLine =null;

            while ((readLine = in.readLine())!=null){
                apiData.append(readLine);
            }
            in.close();

            JSONObject JsonResponse =new JSONObject(apiData.toString());

            System.out.println(JsonResponse);

        }
        else {
            System.out.println("API could not be made");
        }

    }
}