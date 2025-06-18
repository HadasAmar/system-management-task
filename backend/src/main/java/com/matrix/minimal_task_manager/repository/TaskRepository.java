package com.matrix.minimal_task_manager.repository;

import com.matrix.minimal_task_manager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{

//The interface uses the basic operations provided by JpaRepository:

//  addTask                 → save(task)
//  getAllTasks             → findAll()
//  findTaskById            → findById(id)
//  deleteTask              → deleteById(id)
//  markTaskAsCompleted     → findById(id)+ save(task)
}