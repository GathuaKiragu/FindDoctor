package com.example.kiragu.finddoctor.models;

import java.util.ArrayList;
import java.util.List;

import org.parceler.Parcel;

/**
 * Created by kiragu on 6/2/17.
 */
@Parcel
public class Doctor{
    String name;
    String title;
    String image;
    String gender;
    double latitude;
    String index;
    private String pushId;
    double longitude;
    List<String> specialty = new ArrayList<>();
    List<String> language = new
            ArrayList<>();
    String website;
    String address;
    String bio;
    List<String> phone = new ArrayList<>();
//    private double mRating;

//    Empty constructor for parceler
public Doctor(){}
    // Constructor
    public Doctor(String name, String title, String image, String gender,double latitude,double longitude, List<String> specialty, List<String> language, String website, String address, String bio,
                  ArrayList<String> phone) {
        this.name = name;
        this.title = title;
        this.image = image;
        this.gender =gender;
        this.latitude = latitude;
        this.longitude = longitude;
        this.specialty = specialty;
        this.language = language;
        this.address = address;
        this.bio = bio;
        this.phone = phone;
        this.website= website;
        this.index="not specified";
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

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
    public String getPushId(){
        return pushId;
    }

    public void setPushId(String pushId){
        this.pushId = pushId;
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

