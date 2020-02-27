package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Staff1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Boss1 boss1;

    public Staff1() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boss1 getBoss1() {
        return boss1;
    }

    public void setBoss1(Boss1 boss1) {
        this.boss1 = boss1;
    }
}