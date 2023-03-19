package edu.ou.humansyncdataservice.data.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Avatar", schema = "HumanQueryService", catalog = "")
public class AvatarDocument {
    @Basic
    @Column(name = "_id")
    private String id;
    @Basic
    @Column(name = "createdAt")
    private String createdAt;
    @Basic
    @Column(name = "isSelected")
    private String isSelected;
    @Basic
    @Column(name = "oId")
    private Integer oId;
    @Basic
    @Column(name = "url")
    private String url;
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

    public String getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(String isSelected) {
        this.isSelected = isSelected;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        AvatarDocument that = (AvatarDocument) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(isSelected, that.isSelected) && Objects.equals(oId, that.oId) && Objects.equals(url, that.url) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, isSelected, oId, url, userId);
    }
}
