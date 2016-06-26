package org.college.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by byaxe on 6/25/16.
 */
@Entity
@Table(name = "groups")
public class GroupEntity extends AbstractEntity implements Serializable {

    private String number;
    private StudentEntity student;

    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
