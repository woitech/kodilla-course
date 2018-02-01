package com.kodilla.hibernate.tasklist;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TASKLISTS")
public class TaskList {
    private int id;
    private String listName;
    private String description;

    public TaskList() {
    }

    public TaskList(String listName, String description) {
        // Nie wiem jak zastosować @NotBlank w tym przypadku
        if (listName == null || listName.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.listName = listName;
        this.description = description;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @NotBlank
    @Column(name = "LISTNAME", unique = true)
    public String getListName() {
        return listName;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskList taskList = (TaskList) o;

        if (id != taskList.id) return false;
        if (!listName.equals(taskList.listName)) return false;
        return description != null ? description.equals(taskList.description) : taskList.description == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + listName.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
