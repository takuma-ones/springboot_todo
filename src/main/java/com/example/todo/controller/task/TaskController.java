package com.example.todo.controller.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {

    @GetMapping("/tasks")
    public String list(Model model) {
        var task1 = new TaskDTO(
                1L,
                "Task 1",
                "Description of Task 1",
                "In Progress"
        );
        var task2 = new TaskDTO(
                2L,
                "Task 2",
                "Description of Task 2",
                "Completed"
        );
        var task3 = new TaskDTO(
                3L,
                "Task 3",
                "Description of Task 3",
                "Not Started"
        );

        var taskList = List.of(task1, task2, task3);
        model.addAttribute("taskList", taskList);
        return "tasks/list";
    }
}
