package com.example.soman.array_listdeleteitem;

/**
 * Created by soman on 1/10/2018.
 */

public class CarDetails {
    private String CarName;
    private int seriol_no;

    public CarDetails() {
    }

    public CarDetails(String carName, int seriol_no) {
        CarName = carName;
        this.seriol_no = seriol_no;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getSeriol_no() {
        return String.valueOf(seriol_no);
    }

    public void setSeriol_no(int seriol_no) {
        this.seriol_no = seriol_no;
    }
}
