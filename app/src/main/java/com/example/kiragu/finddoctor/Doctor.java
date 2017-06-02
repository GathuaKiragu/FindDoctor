package com.example.kiragu.finddoctor;

import java.util.ArrayList;

/**
 * Created by kiragu on 6/2/17.
 */

public class Doctor{
    private String mName;
    private String mTitle;
    private String mImage;
    private String mGender;
    private String mSpecialty;
    private String mLanguages;
    private ArrayList<String> mAddress = new ArrayList<>();
    private String mBio;
    private String mPhone;
    private double mRating;
    private String mAvailability;

    // Constructor
    public Doctor(String name, String title, String image, String gender, String specialty, String language, ArrayList<String> address, String bio,
                  String phone, double rating, String availability) {
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

    public String getmSpecialty(){
        return mSpecialty;
    }
    public String getLanguages() {
        return mLanguages;
    }
    public ArrayList<String> getAddress() {
        return mAddress;
    }

    public String getBio() {
        return mBio;
    }
    public String getPhone() {
        return mPhone;
    }
    public double getRating() {
        return mRating;
    }
    public String getmAvailability() {
        return mAvailability;
    }

}

