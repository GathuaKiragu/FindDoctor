package com.example.kiragu.finddoctor.services;

import com.example.kiragu.finddoctor.Constants;
import com.example.kiragu.finddoctor.models.Doctor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kiragu on 6/2/17.
 */

public class BetterDoctorService {

    public static void findDoctors(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

//Creating a new URL using the API_BASE_URL and turn is to a string
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        String url = urlBuilder.build().toString() + location + Constants.API_KEY_QUERY_PARAMETER + Constants.BETTER_DOCTOR_API;
// Calling a request
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
//Method to parse json file from the api and parse it to our doctor constructor
    public ArrayList<Doctor> processResults(Response response) {
        ArrayList<Doctor> doctors = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject betterDoctorJSON = new JSONObject(jsonData);
                JSONArray dataJSON = betterDoctorJSON.getJSONArray("data");

                for (int i = 0; i < dataJSON.length(); i++) {
                    JSONObject doctorsJSON = dataJSON.getJSONObject(i);
                    String firstname = doctorsJSON.getJSONObject("profile").getString("first_name");
                    String lastname = doctorsJSON.getJSONObject("profile").getString("last_name");
                    String title = doctorsJSON.getJSONObject("profile").getString("title");
                    String image = doctorsJSON.getJSONObject("profile").getString("image_url");
                    String gender = doctorsJSON.getJSONObject("profile").getString("gender");

                    ArrayList<String> specialty = new ArrayList<>();
                    JSONArray specialtyJSON = doctorsJSON.getJSONArray("specialties");
                    for (int y = 0; y < specialtyJSON.length(); y++) {
                        specialty.add(specialtyJSON.getJSONObject(y).getString("description").toString());
                    }

                    ArrayList<String> languages = new ArrayList<>();
                    JSONArray languageJSON = doctorsJSON.getJSONArray("practices").getJSONObject(0).getJSONArray("languages");
                    for (int y = 0; y < languageJSON.length(); y++) {
                        languages.add(languageJSON.getJSONObject(0).getString("name").toString());
                    }

                    String state = doctorsJSON.getJSONArray("practices").getJSONObject(0).getJSONObject("visit_address").optString("state");
                    String street =doctorsJSON.getJSONArray("practices").getJSONObject(0).getJSONObject("visit_address").optString("street");

                    String bio = doctorsJSON.getJSONObject("profile").getString("bio");
                    String website=doctorsJSON.getJSONArray("practices").getJSONObject(0).getString("website");
                    ArrayList<String> phone = new ArrayList<>();
                    JSONArray phoneJSON =doctorsJSON.getJSONArray("practices").getJSONObject(0).getJSONArray("phones");
                    for (int y = 0; y < phoneJSON.length(); y++) {
                        phone.add(phoneJSON.getJSONObject(y).getString("number").toString());
                    }

//                    ArrayList<String> ratingJson = new ArrayList<>();
//                    JSONArray ratingJSON = doctorsJSON.getJSONArray("ratings");
//                    double rating = ratingJSON.getJSONObject(0).getDouble("rating");
                    String name = firstname + " " + lastname;
                    String address = state + ", " + street;
                    Doctor doctor = new Doctor(name, title, image, gender, specialty, languages, address, bio, website,
                            phone);
                    doctors.add(doctor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return doctors;
    }
}