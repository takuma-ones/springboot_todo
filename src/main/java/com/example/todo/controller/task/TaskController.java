package com.example.todo.controller.task;

import com.example.todo.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    // タスクサービスのインスタンスを作成
    private final TaskService taskService;

    @GetMapping
    public String list(Model model) {

        List<TaskDTO> taskList = taskService.find()
                .stream()
                .map(TaskDTO::toDTO)
                .toList();

        model.addAttribute("taskList", taskList);
        return "tasks/list";
    }

    @GetMapping("/{id}")
    public String showDetail(@PathVariable("id") long id, Model model) {
        TaskDTO task = taskService.findById(id)
                .map(TaskDTO::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Task not found: " + id));
        model.addAttribute("task", task);
        return "tasks/detail";
    }

    @GetMapping("/create")
    public String showCreateForm(@ModelAttribute TaskForm form) {
        return "tasks/create";
    }

    @PostMapping("/create")
    public String create(@Validated TaskForm form, BindingResult result) {

        // バリデーションエラーがある場合は、エラーメッセージを表示する
        if (result.hasErrors()) {
            return showCreateForm(form);
        }

        // タスクを作成する
        taskService.create(form.toEntity());

        return "redirect:/tasks";
    }
}
