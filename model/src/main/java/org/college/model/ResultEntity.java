package org.college.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by byaxe on 6/26/16.
 */
@Entity
@Table(name = "results")
public class ResultEntity extends AbstractEntity implements Serializable {

    private ExamEntity exam;
    private StudentEntity student;
    private Integer mark;

    @ManyToOne(targetEntity = ExamEntity.class)
    @JoinColumn(name = "exam_id")
    public ExamEntity getExam() {
        return exam;
    }

    public void setExam(ExamEntity exam) {
        this.exam = exam;
    }

    @ManyToOne(targetEntity = StudentEntity.class)
    @JoinColumn(name = "student_id")
    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    @Column(name = "mark")
    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
