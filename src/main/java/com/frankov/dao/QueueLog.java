package com.frankov.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "queue_log")
public class QueueLog {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "data")
    private Date data;

    @Column(name = "start_time_of_wait")
    private Date startTimeOfWait;

    @Column(name = "end_time_of_wait")
    private Date endTimeOfWait;

    @Column(name = "end_time_of_service")
    private Date endTimeOfService;

    @Column(name = "branches_id")
    private long officeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getStartTimeOfWait() {
        return startTimeOfWait;
    }

    public void setStartTimeOfWait(Date startTimeOfWait) {
        this.startTimeOfWait = startTimeOfWait;
    }

    public Date getEndTimeOfWait() {
        return endTimeOfWait;
    }

    public void setEndTimeOfWait(Date endTimeOfWait) {
        this.endTimeOfWait = endTimeOfWait;
    }

    public Date getEndTimeOfService() {
        return endTimeOfService;
    }

    public void setEndTimeOfService(Date endTimeOfService) {
        this.endTimeOfService = endTimeOfService;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }
}
