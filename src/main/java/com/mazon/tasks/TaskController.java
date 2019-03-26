package com.mazon.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/task")
    public Task gravaTask(@RequestBody Task task){
        return taskRepository.save(task);
    }
}
