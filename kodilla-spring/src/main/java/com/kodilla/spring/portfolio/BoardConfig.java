package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.*;

@Configuration
public class BoardConfig {
    @Bean
    public Board board() {
        return new Board(toDoList(), inProgressList(), doneList());
    }

    @Bean
    @Scope("prototype")
    public TaskList toDoList() {
        return new TaskList();
    }

    @Bean
    @Scope("prototype")
    public TaskList inProgressList() {
        return new TaskList();
    }

    @Bean
    @Scope("prototype")
    public TaskList doneList() {
        return new TaskList();
    }
}
