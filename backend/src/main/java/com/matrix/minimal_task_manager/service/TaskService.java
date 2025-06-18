package com.matrix.minimal_task_manager.service;

import com.matrix.minimal_task_manager.dto.TaskRequest;
import com.matrix.minimal_task_manager.model.Task;
import com.matrix.minimal_task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepo;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepo = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Optional<Task> getById(Long id) {

        return taskRepo.findById(id);
    }

    public Task addTask(TaskRequest taskRequest) {
        Task task = new Task(taskRequest.getTaskName(), taskRequest.getTaskDescription());
        taskRepo.save(task);
        return task;
    }

    public Optional<Task> markTaskAsCompleted(Long taskId) {
        Optional<Task> task = taskRepo.findById(taskId);
        if (task.isPresent()) {
            task.get().setCompleted(true);
            taskRepo.save(task.get());
        }
        return task;
    }

    public boolean deleteById(Long id) {
        if(taskRepo.existsById(id)){
            taskRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
