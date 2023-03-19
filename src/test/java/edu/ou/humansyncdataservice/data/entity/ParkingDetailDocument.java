package edu.ou.humansyncdataservice.data.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ParkingDetail", schema = "HumanQueryService", catalog = "")
public class ParkingDetailDocument {
    @Basic
    @Column(name = "_id")
    private String id;
    @Basic
    @Column(name = "joinDate")
    private String joinDate;
    @Basic
    @Column(name = "parkingId")
    private Integer parkingId;
    @Basic
    @Column(name = "userId")
    private Integer userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingDetailDocument that = (ParkingDetailDocument) o;
        return Objects.equals(id, that.id) && Objects.equals(joinDate, that.joinDate) && Objects.equals(parkingId, that.parkingId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, joinDate, parkingId, userId);
    }
}
