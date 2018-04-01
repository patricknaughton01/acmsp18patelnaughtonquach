package com.example.stefan.safeezersize;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AlertRequest extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... urls) {
        try {
            URL url = new URL("https://api-sandbox.safetrek.io/v1/alarms");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Accept","application/json");
            conn.setRequestProperty("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik5FWTBPVVV3TVRSRU5qUTRSVUZDTkVJd01rUTBSVEUwUVRJMFF6ZzRSVGc1T0RBMFJEWXhOUSJ9.eyJodHRwOi8vY2xpZW50LW5hbWUiOiJIQUNLX1VWQSIsImlzcyI6Imh0dHBzOi8vbG9naW4tc2FuZGJveC5zYWZldHJlay5pby8iLCJzdWIiOiJzbXN8NWFiZmJkN2VhNjgwM2E5MTkxMjJjNmM5IiwiYXVkIjpbImh0dHBzOi8vYXBpLXNhbmRib3guc2FmZXRyZWsuaW8iLCJodHRwczovL3NhZmV0cmVrLXNhbmRib3guYXV0aDAuY29tL3VzZXJpbmZvIl0sImlhdCI6MTUyMjUxNzIyNCwiZXhwIjoxNTIyNTUzMjI0LCJhenAiOiJtNXFYRjV6dE9kVDRjZFF0VWJaVDJnckJoRjE4N3Z3NiIsInNjb3BlIjoib3BlbmlkIHBob25lIG9mZmxpbmVfYWNjZXNzIn0.rtTBxnLmP29ktg01ugrGeYA42CsmSh5W7C84v6c4wn8YmofGLjynHjHypOQZ2O0Ktc3TCZNhMzCfoq9k_zq07f1pUCvtGRtCl8AsLsDGdv_5YpSdgRTJTK-rx4IzjYSElf_RKGYG0N9Hf7mF1J40Y-YBaB-_c6CHFqQ8QxPsOyj_wabbguhP9SwDgj-zvNq3FmBNIzPui1Aiknthc4754woNpivYbA9kbiY_0mAesl5z2USEa2YuefuFPFNMDf9B4cqD_VZvBH8zwOUqelAgtwTU0vSxU3IWjAX8p7XMMpJgsZz_eL-XNyZBHjpC2jANeYz6UVsViH-qaZrK5Zz9Ng");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            JSONObject services = new JSONObject();
            services.put("police", "false");
            services.put("fire", "false");
            services.put("medical", "true");

            JSONObject location = new JSONObject();
            services.put("lat", 38.9582381);
            services.put("long", -77.0244287);
            services.put("accuracy", 5);

            JSONObject jsonParam = new JSONObject();
            jsonParam.put("services", services);
            jsonParam.put("location.coordinates", location);

            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
            //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
            os.writeBytes(jsonParam.toString());

            os.flush();
            os.close();

            conn.disconnect();
            return jsonParam.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
