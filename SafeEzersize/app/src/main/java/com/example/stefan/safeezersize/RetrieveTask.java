package com.example.stefan.safeezersize;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RetrieveTask extends AsyncTask<Void, Void, String> {

    private Exception exception;

    protected void onPreExecute() {
    }

    protected String doInBackground(Void... urls) {
        try {
            URL url = new URL("https://account-sandbox.safetrek.io/authorize?client_id=m5qXF5ztOdT4cdQtUbZT2grBhF187vw6&scope=openid phone offline_access&response_type=code&redirect_uri=");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }

    protected void onPostExecute(String response) {
        if(response == null) {
            response = "THERE WAS AN ERROR";
        }
        System.out.println(response);
    }
}
