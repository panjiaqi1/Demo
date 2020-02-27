package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * 老板实体（Boss1对应Staff1）
 * 一个老板对应多个员工
 */
@Entity
public class Boss1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "boss1")
    private List<Staff1> staff1sList;

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

    public List<Staff1> getStaff1sList() {
        return staff1sList;
    }

    public void setStaff1sList(List<Staff1> staff1sList) {
        this.staff1sList = staff1sList;
    }

    public Boss1() {
    }
}
