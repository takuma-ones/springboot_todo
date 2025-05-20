package com.example.todo.service.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    public List<TaskEntity> find() {
        var task1 = new TaskEntity(
                1L,
                "Task 1",
                "Description of Task 1",
                TaskStatus.TOTO
        );
        var task2 = new TaskEntity(
                2L,
                "Task 2",
                "Description of Task 2",
                TaskStatus.DOING
        );
        var task3 = new TaskEntity(
                3L,
                "Task 3",
                "Description of Task 3",
                TaskStatus.DONE
        );
        var task4 = new TaskEntity(
                4L,
                "Task 4",
                "Description of Task 4",
                TaskStatus.TOTO
        );

        return List.of(task1, task2, task3, task4);
    }
}
