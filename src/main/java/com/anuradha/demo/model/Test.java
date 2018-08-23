package com.anuradha.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Test implements Serializable {
    @Id
    private
    int id;
    private String name;

    public Test() {
    }

    public Test(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
