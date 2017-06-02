package com.example.kiragu.finddoctor;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by kiragu on 6/2/17.
 */

public class BetterDoctorService {

    public static void findLocation(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

//Creating a new URL using the API_BASE_URL and turn is to a string
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YOUR_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.BETTER_DOCTOR_API);
        String url = urlBuilder.build().toString();

// Calling a request

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
