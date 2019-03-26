package com.mazon.tasks;


import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(generator = "task_generator",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "task_generator", sequenceName = "task_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    private String titulo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
