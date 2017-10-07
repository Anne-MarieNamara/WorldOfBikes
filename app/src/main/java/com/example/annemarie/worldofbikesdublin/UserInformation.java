package com.example.annemarie.worldofbikesdublin;

/**
 * Created by Anne-Marie on 07/10/2017.
 */

// This is the information I want to save in the Firebase database
public class UserInformation {


    // always use public here
    public String name;
    public String address;

    public UserInformation(){

    }


    // constructor
    public UserInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
