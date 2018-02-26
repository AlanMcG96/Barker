package com.example.alan.barker;

/**
 * Created by Alan on 05/02/2018.
 */

public class Dog {
    public String name;
    public String breed;
    public String age;
    public String gender;
    public String dogID;





    //required default constructor
    public Dog() {
    }

    public Dog(String name, String breed,String age, String gender, String dogID) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.dogID = dogID;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDogID(){
        return dogID;
    }

    public void setDogID(String dogID){
        this.dogID = dogID;
    }

}
