package com.example.week4_day5.Controller;


import com.example.week4_day5.Model.TaskTracker;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("abi/v1/tasktracker")
public class TaskTrackerController {


ArrayList<TaskTracker> taskTrackers = new ArrayList<>();
@GetMapping("/get")
public ArrayList<TaskTracker> getTaskTrackers() {
    return taskTrackers;
}

    @GetMapping("/check/{index}")
    public String checkTaskTrackers(@PathVariable int index) {
    if(taskTrackers.get(index).isStatus() == true) {
        taskTrackers.get(index).setStatus(false);
    }
    else taskTrackers.get(index).setStatus(true);

    return "Task tracker check completed";

    }

@PostMapping("/add")
public String add(@RequestBody TaskTracker taskTracker) {
    taskTrackers.add(taskTracker);

   return "add successfully";
}

    @PostMapping("/update/{index}")
    public String updateTask(@PathVariable int index , @RequestBody TaskTracker taskTracker) {
        taskTrackers.set(index, taskTracker);

        return "update successfully";
    }


    @DeleteMapping("delete/{index}")
    public String deleteTask(@PathVariable int index) {
    taskTrackers.remove(index);
        return "delete successfully";
    }



    @GetMapping("/search/{title}")
    public String searchByTitle(@PathVariable String title) {
        for (TaskTracker task : taskTrackers) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                return "The title is found";
            }
        }
        return "The title is not found";
    }



}
