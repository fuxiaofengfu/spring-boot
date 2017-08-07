package com.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by xiaofengfu on 2017/6/9.
 */
@Entity
@Table(name = "spring_boot_person")
public class SpringBootPerson implements Serializable {

    private String name;
    private String gender;
    private Integer id;
    private String transPropagation;
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransPropagation() {
        return transPropagation;
    }

    public void setTransPropagation(String transPropagation) {
        this.transPropagation = transPropagation;
    }
}
