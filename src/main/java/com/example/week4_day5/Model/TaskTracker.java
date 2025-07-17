package com.example.week4_day5.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskTracker {

    private String id;
    private String title;
    private String description;
    private boolean status;


}
