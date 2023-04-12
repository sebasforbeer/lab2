package com.example.lab2;

import com.example.lab2.beans.MyTask;
import com.example.lab2.dataClasses.Add_task_json;
import com.example.lab2.dataClasses.FilterData;
import com.example.lab2.dataClasses.Update_task_json;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/execute")

public class MyTaskController {
    private final MyTaskService myTaskService;
    private final CleanService cleanService;

    public MyTaskController(MyTaskService myTaskService, CleanService cleanService) {
        this.myTaskService = myTaskService;
        this.cleanService = cleanService;
    }

    @GetMapping("/q")
    @ResponseBody
    public String q() {
        return "ok";
    }

    @PostMapping("/add_task")
    @ResponseBody
    public String addTask(@RequestBody @NonNull Add_task_json task) {
        return myTaskService.saveMyTask(task);
    }

    @PostMapping("/update_task")
    @ResponseBody
    public String updateTask(@RequestBody @NonNull Update_task_json task) {
        return myTaskService.updateMyTask(task);
    }

    @DeleteMapping("/delete_task")
    @ResponseBody
    public String deleteTask(@RequestParam @NonNull String taskType) {
        return myTaskService.deleteMyTask(taskType);
    }

    @GetMapping("/tasks")
    @ResponseBody
    public MyTask[] tasks() {
        return myTaskService.getTasks();
    }

    @GetMapping("/task")
    @ResponseBody
    public String task(@RequestParam @NonNull String taskType) {
        return myTaskService.getTask(taskType);
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<FilterData> filter(@RequestParam @NonNull String taskDateEnd) {
        return myTaskService.filter(taskDateEnd);
    }

    @DeleteMapping("/clean")
    @ResponseBody
    public String clean() {
        return cleanService.clean();
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public String er(HttpMessageNotReadableException ifx) {
        return "some error with your values" + ifx.toString();
    }


}
