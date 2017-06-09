package com.example.kiragu.finddoctor.models;

import java.util.ArrayList;
import java.util.List;

import org.parceler.Parcel;

/**
 * Created by kiragu on 6/2/17.
 */
@Parcel
public class Doctor{
    private String name;
    private String title;
    private String image;
    private String gender;
    private List<String> specialty = new ArrayList<>();
    private List<String> language = new
            ArrayList<>();
    private String website;
    private String address;
    private String bio;
    private List<String> phone = new ArrayList<>();
//    private double mRating;

//    Empty constructor for parceler
public Doctor(){}
    // Constructor
    public Doctor(String name, String title, String image, String gender, List<String> specialty, List<String> language, String website, String address, String bio,
                  ArrayList<String> phone) {
        this.name = name;
        this.title = title;
        this.image = image;
        this.gender =gender;
        this.specialty = specialty;
        this.language = language;
        this.address = address;
        this.bio = bio;
        this.phone = phone;
        this.website= website;
//        this.mRating = rating;


    }
//    getter methods

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return  image;
    }

    public String getGender() {
        return gender;
    }

    public List<String> getSpecialty(){
        return specialty;
    }
    public List<String> getLanguages() {
        return language;
    }
    public  String getWebsite(){return  website; }
    public String getAddress() {
        return address;
    }
    public String getBio() {
        return bio;
    }
    public List<String> getPhone() {
        return phone;
    }
//    public double getRating() {
//        return mRating;
//    }
}

