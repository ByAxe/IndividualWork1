package org.college.model;

import org.college.core.Sex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by byaxe on 6/25/16.
 */
@Entity
@Table(name = "teachers")
public class TeacherEntity extends AbstractEntity implements Serializable {

    private String name;
    private Integer age;
    private Sex sex;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "sex")
    @Enumerated
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
