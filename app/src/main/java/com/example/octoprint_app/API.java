package com.example.octoprint_app;

import android.os.AsyncTask;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class API extends AsyncTask<String, String, JSONObject> {
    @Override
    protected JSONObject doInBackground(String... params) {
        String param = params[0];
        String[] elements = param.split(" ");
        try {

            URL url = new URL("URL HERE");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;
            http.setRequestMethod("POST");
            http.setDoOutput(true);

            JSONObject obj = new JSONObject();

            OutputStreamWriter wr = new OutputStreamWriter(http.getOutputStream()); // https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
            wr.write(obj.toString());
            wr.flush();

            StringBuilder sb = new StringBuilder();

            int HttpResult = http.getResponseCode();

            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(http.getInputStream(), StandardCharsets.UTF_8));

                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                Object json = JSONValue.parse(sb.toString());
                JSONObject finalResult = (JSONObject) json;
                http.disconnect();

                return finalResult;

            } else {
                http.disconnect();
                return null;
            }
        } catch (IOException error) {
            error.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        super.onPostExecute(result);

    }


}