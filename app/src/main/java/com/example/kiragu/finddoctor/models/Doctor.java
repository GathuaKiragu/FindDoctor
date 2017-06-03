package com.example.kiragu.finddoctor.models;

import java.util.ArrayList;

/**
 * Created by kiragu on 6/2/17.
 */

public class Doctor{
    private String mName;
    private String mTitle;
    private String mImage;
    private String mGender;
    private ArrayList<String> mSpecialty = new ArrayList<>();
    private ArrayList<String> mLanguages = new ArrayList<>();
    private String mAddress;
    private String mBio;
    private ArrayList<String> mPhone = new ArrayList<>();
    private double mRating;
    private String mAvailability;

    // Constructor
    public Doctor(String name, String title, String image, String gender, ArrayList<String> specialty, ArrayList<String> language, String address, String bio,
                  ArrayList<String> phone, double rating, String availability) {
        this.mName = name;
        this.mTitle = title;
        this.mImage = image;
        this.mGender =gender;
        this.mSpecialty = specialty;
        this.mLanguages = language;
        this.mAddress = address;
        this.mBio = bio;
        this.mPhone = phone;
        this.mRating = rating;
        this.mAvailability = availability;


    }
//    getter methods

    public String getName() {
        return mName;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getImage() {
        return  mImage;
    }

    public String getGender() {
        return mGender;
    }

    public ArrayList<String> getSpecialty(){
        return mSpecialty;
    }
    public ArrayList<String> getLanguages() {
        return mLanguages;
    }
    public String getAddress() {
        return mAddress;
    }

    public String getBio() {
        return mBio;
    }
    public ArrayList<String> getPhone() {
        return mPhone;
    }
    public double getRating() {
        return mRating;
    }
    public String getmAvailability() {
        return mAvailability;
    }

}

