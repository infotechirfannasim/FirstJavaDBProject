package com.example.firstjavadbproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "PROFILES")
public class Profile {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ATTITUDE_STATUS")
    private String attitudeStatus;

    @Column(name = "ATTENDANCE_STATUS")
    private String attendanceStatus;

    @Column(name = "PUNCTUALITY")
    private String punctuality;

    @Column(name = "PHOTO")
    @Lob
    @JsonIgnore
    private byte[] photo;

    public Profile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttitudeStatus() {
        return attitudeStatus;
    }

    public void setAttitudeStatus(String attitudeStatus) {
        this.attitudeStatus = attitudeStatus;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(String punctuality) {
        this.punctuality = punctuality;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
