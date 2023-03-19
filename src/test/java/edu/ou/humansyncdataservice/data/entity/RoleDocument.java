package edu.ou.humansyncdataservice.data.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Role", schema = "HumanQueryService", catalog = "")
public class RoleDocument {
    @Basic
    @Column(name = "_id")
    private String id;
    @Basic
    @Column(name = "display")
    private String display;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "oId")
    private Integer oId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDocument that = (RoleDocument) o;
        return Objects.equals(id, that.id) && Objects.equals(display, that.display) && Objects.equals(name, that.name) && Objects.equals(oId, that.oId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, display, name, oId);
    }
}
