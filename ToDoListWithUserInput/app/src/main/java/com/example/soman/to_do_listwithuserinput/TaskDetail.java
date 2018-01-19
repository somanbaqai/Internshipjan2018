package com.example.soman.to_do_listwithuserinput;

/**
 * Created by soman on 1/9/2018.
 */

public class TaskDetail {
    private String title;
    private String description;

    public TaskDetail() {
    }

    public TaskDetail(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
