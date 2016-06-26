package org.college.model;

import org.college.core.Sex;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by byaxe on 6/25/16.
 */
@Entity
@Table(name = "students")
public class StudentEntity extends AbstractEntity implements Serializable {

    private String name;
    private Integer age;
    private Sex sex;
    private GroupEntity group;
    private Set<ResultEntity> results = new HashSet<>();

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

    @OneToOne(mappedBy = "group_number")
    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    @OneToMany(mappedBy = "student")
    public Set<ResultEntity> getResults() {
        return results;
    }

    public void setResults(Set<ResultEntity> results) {
        this.results = results;
    }
}
