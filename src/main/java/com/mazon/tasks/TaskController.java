package com.mazon.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks(){
        List<Task> list = (List<Task>) taskRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long id){
        Task task = taskRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada: " + id));
        return ResponseEntity.ok().body(task);
    }

    @PostMapping("/task")
    public Task gravaTask(@RequestBody Task task){
        return taskRepository.save(task);
    }
}
