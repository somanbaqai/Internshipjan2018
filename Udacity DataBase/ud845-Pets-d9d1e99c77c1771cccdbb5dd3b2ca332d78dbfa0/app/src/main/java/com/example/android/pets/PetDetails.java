package com.example.android.pets;

/**
 * Created by soman on 1/19/2018.
 */

public class PetDetails {
    private String name;
    private int gender;
    private String breed;
    private int weight;

    public PetDetails(String name, int gender, String breed, int weight) {
        this.name = name;
        this.gender = gender;
        this.breed = breed;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return  String.valueOf(gender);
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getWeight() {
        return String.valueOf(weight);
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
