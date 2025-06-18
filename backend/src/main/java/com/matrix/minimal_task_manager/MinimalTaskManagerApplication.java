package com.matrix.minimal_task_manager;

import com.matrix.minimal_task_manager.dto.TaskRequest;
import com.matrix.minimal_task_manager.model.Task;
import com.matrix.minimal_task_manager.service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Optional;

@SpringBootApplication
public class MinimalTaskManagerApplication {

	private final TaskService taskService;

	public MinimalTaskManagerApplication(TaskService taskService) {
		this.taskService = taskService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MinimalTaskManagerApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void demoTaskFlow() {
		System.out.println("\n----- Starting Task Demo -----");

		// Add tasks
		taskService.addTask(new TaskRequest("Bake a cake", "For the birthday celebration"));
		taskService.addTask(new TaskRequest("Read a book", "Read the new book I bought"));
		taskService.addTask(new TaskRequest("Clean the room", "Tidy, sweep and mop the floor"));
		taskService.addTask(new TaskRequest("Call grandma", "Check in and say hello"));
		taskService.addTask(new TaskRequest("Practice LeetCode", "Solve at least two problems"));

		// Display all tasks
		System.out.println("\nAll tasks:");
		taskService.getAllTasks().forEach(System.out::println);

		// Mark a task as completed
		System.out.println("\nMarking task with ID 2 as completed...");
		taskService.markTaskAsCompleted(2L);

		// Display tasks again
		System.out.println("\nAll tasks after marking one task as completed:");
		taskService.getAllTasks().forEach(System.out::println);

		// Delete a task
		System.out.println("\nDeleting task with ID 3...");
		taskService.deleteById(3L);

		// Display tasks again
		System.out.println("\nAll tasks after deletion one task:");
		taskService.getAllTasks().forEach(System.out::println);

		// Attempt to delete and complete non-existent tasks
		System.out.println("\nTrying to delete non-existent task with ID 10...");
		boolean deleted = taskService.deleteById(10L);
		if (!deleted) {
			System.out.println("Task 10 not found");
		}

		System.out.println("\nTrying to complete non-existent task with ID 10...");
		Optional<Task> completed = taskService.markTaskAsCompleted(10L);
		if (completed.isEmpty()) {
			System.out.println("Task 10 not found");
		}

		System.out.println("\n----- Task Demo Finished Successfully -----");
	}

}

