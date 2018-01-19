package com.example.soman.todolist;

/**
 * Created by soman on 1/9/2018.
 */

public class TaskDetail {
    String title;
    String Description;

    public TaskDetail() {

    }

    public TaskDetail(String title, String description) {
        this.title = title;
        Description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
