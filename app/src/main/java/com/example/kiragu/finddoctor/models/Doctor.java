package com.example.kiragu.finddoctor.models;

import java.util.ArrayList;
import org.parceler.Parcel;

/**
 * Created by kiragu on 6/2/17.
 */
@Parcel
public class Doctor{
    private String mName;
    private String mTitle;
    private String mImage;
    private String mGender;
    private ArrayList<String> mSpecialty = new ArrayList<>();
    private ArrayList<String> mLanguages = new ArrayList<>();
    private String mWebsite;
    private String mAddress;
    private String mBio;
    private ArrayList<String> mPhone = new ArrayList<>();
//    private double mRating;

//    Empty constructor for parceler
public Doctor(){}
    // Constructor
    public Doctor(String name, String title, String image, String gender, ArrayList<String> specialty, ArrayList<String> language, String website, String address, String bio,
                  ArrayList<String> phone) {
        this.mName = name;
        this.mTitle = title;
        this.mImage = image;
        this.mGender =gender;
        this.mSpecialty = specialty;
        this.mLanguages = language;
        this.mAddress = address;
        this.mBio = bio;
        this.mPhone = phone;
        this.mWebsite= website;
//        this.mRating = rating;


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
    public  String getWebsite(){return  mWebsite; }
    public String getAddress() {
        return mAddress;
    }
    public String getBio() {
        return mBio;
    }
    public ArrayList<String> getPhone() {
        return mPhone;
    }
//    public double getRating() {
//        return mRating;
//    }
}

