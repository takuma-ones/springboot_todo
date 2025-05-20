package com.example.todo.repository.task;

import com.example.todo.service.task.TaskEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskRepository {

    @Select("SELECT * FROM tasks")
    List<TaskEntity> select();

    @Select("SELECT * FROM tasks WHERE id = #{id}")
    Optional<TaskEntity> selectById(@Param("id") long id);
}
