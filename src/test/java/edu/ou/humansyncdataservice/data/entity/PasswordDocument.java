package edu.ou.humansyncdataservice.data.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Password", schema = "HumanQueryService", catalog = "")
public class PasswordDocument {
    @Basic
    @Column(name = "_id")
    private String id;
    @Basic
    @Column(name = "createdAt")
    private String createdAt;
    @Basic
    @Column(name = "oId")
    private Integer oId;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "userId")
    private Integer userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        PasswordDocument that = (PasswordDocument) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(oId, that.oId) && Objects.equals(password, that.password) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, oId, password, userId);
    }
}
