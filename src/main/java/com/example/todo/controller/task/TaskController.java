package com.example.todo.controller.task;

import com.example.todo.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {

    // タスクサービスのインスタンスを作成
    private final TaskService taskService;

    @GetMapping("/tasks")
    public String list(Model model) {

        List<TaskDTO> taskList = taskService.find()
                .stream()
                .map(TaskDTO::toDTO)
                .toList();

        model.addAttribute("taskList", taskList);
        return "tasks/list";
    }

    @GetMapping("/tasks/{id}")
    public String showDetail(@PathVariable("id") long id, Model model) {
        TaskDTO task = taskService.findById(id)
                .map(TaskDTO::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Task not found: " + id));
        model.addAttribute("task", task);
        return "tasks/detail";
    }
}
