package com.example.todo.controller.task;

import com.example.todo.service.task.TaskEntity;
import com.example.todo.service.task.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TaskForm(
        @NotBlank
        @Size(max = 256, message = "256文字以内で入力してください")
        String summary,
        String description,
        @NotBlank
        @Pattern(regexp = "TODO|DOING|DONE", message = "TODO, DOING, DONEのいずれかを入力してください")
        String status
) {
    public TaskEntity toEntity() {
        return new TaskEntity(
                null,
                summary,
                description,
                TaskStatus.valueOf(status)
        );
    }
}
