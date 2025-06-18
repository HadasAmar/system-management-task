package com.matrix.minimal_task_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {

    @NotBlank(message = "Name of task is required")
    @Size(max = 50, message = "Task name must not exceed 50 characters")
    private String taskName;

    @Size(max=200,message ="Description must not exceed 100 characters")
    private String taskDescription;
}
