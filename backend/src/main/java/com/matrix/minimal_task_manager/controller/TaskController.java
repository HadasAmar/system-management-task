package com.matrix.minimal_task_manager.controller;

import com.matrix.minimal_task_manager.dto.ApiResponse;
import com.matrix.minimal_task_manager.dto.TaskRequest;
import com.matrix.minimal_task_manager.model.Task;
import com.matrix.minimal_task_manager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService  taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Task>>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        ApiResponse<List<Task>> response = new ApiResponse<>(true, "Tasks fetched successfully", tasks);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getById(id);
        if (task.isPresent()) {
            ApiResponse<Task> response = new ApiResponse<>(true, "Task with ID "+ id +" found", task.get());
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<Task> response = new ApiResponse<>(false, "Task with ID"+ id +" not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Task>> createTask(@RequestBody @Valid TaskRequest taskRequest) {
        Task created=taskService.addTask(taskRequest);
        ApiResponse<Task> response = new ApiResponse<>(true, "Task created successfully", created);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> updateTask(@PathVariable Long id) {
        Optional<Task> updated = taskService.markTaskAsCompleted(id);
        if (updated.isPresent()) {
            ApiResponse<Task> response = new ApiResponse<>(true, "Task with ID " +id+ " updated successfully", updated.get());
            return ResponseEntity.ok(response);
        }
        ApiResponse<Task> response = new ApiResponse<>(false, "Task with ID "+ id+ " not found", null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> deleteTask(@PathVariable Long id) {
        boolean deleted=taskService.deleteById(id);
        if(deleted) {
            ApiResponse<Task> response = new ApiResponse<>(true, "Task with ID " +id+ " deleted successfully", null);
            return ResponseEntity.ok(response);
        }
        ApiResponse<Task> response = new ApiResponse<>(false, "Task  with ID "+ id +" not found", null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
