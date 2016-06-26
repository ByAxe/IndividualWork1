package org.college.model;

import org.college.core.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

/**
 * Created by byaxe on 6/25/16.
 */
@Entity
@Table(name = "exams")
public class ExamEntity extends AbstractEntity implements Serializable {
    private String title;
    private Date scheduled_date;
    private Long cabinet;
    private Status status;
    private Set<GroupEntity> groups = new HashSet<>();
    private Set<ResultEntity> results = new HashSet<>();

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "scheduled_date")
    public Date getScheduled_date() {
        return scheduled_date;
    }

    public void setScheduled_date(Date scheduled_date) {
        this.scheduled_date = scheduled_date;
    }

    @Column(name = "cabinet")
    public Long getCabinet() {
        return cabinet;
    }

    public void setCabinet(Long cabinet) {
        this.cabinet = cabinet;
    }

    @Column(name = "status")
    @Enumerated
    public Status getStatus() {
        return status;
    }

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "results", joinColumns = {
            @JoinColumn(name = "exam_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "student_id")
    })
    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<GroupEntity> getGroups() {
        return groups;
    }

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "groups_exams", joinColumns = {
            @JoinColumn(name = "exam_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "group_id")
    })
    public void setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
    }

    @OneToMany(mappedBy = "exam")
    public Set<ResultEntity> getResults() {
        return results;
    }

    public void setResults(Set<ResultEntity> results) {
        this.results = results;
    }
}
