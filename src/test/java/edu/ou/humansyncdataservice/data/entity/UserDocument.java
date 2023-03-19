package edu.ou.humansyncdataservice.data.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "User", schema = "HumanQueryService", catalog = "")
public class UserDocument {
    @Basic
    @Column(name = "_id")
    private String id;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "createdAt")
    private String createdAt;
    @Basic
    @Column(name = "dateOfBirth")
    private String dateOfBirth;
    @Basic
    @Column(name = "firstName")
    private String firstName;
    @Basic
    @Column(name = "lastName")
    private String lastName;
    @Basic
    @Column(name = "nationality")
    private String nationality;
    @Basic
    @Column(name = "oId")
    private Integer oId;
    @Basic
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Basic
    @Column(name = "slug")
    private String slug;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "gender")
    private Integer gender;
    @Basic
    @Column(name = "roleId")
    private Integer roleId;
    @Basic
    @Column(name = "token")
    private String token;
    @Basic
    @Column(name = "idCard")
    private String idCard;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDocument that = (UserDocument) o;
        return Objects.equals(id, that.id) && Objects.equals(address, that.address) && Objects.equals(createdAt, that.createdAt) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(nationality, that.nationality) && Objects.equals(oId, that.oId) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(slug, that.slug) && Objects.equals(username, that.username) && Objects.equals(gender, that.gender) && Objects.equals(roleId, that.roleId) && Objects.equals(token, that.token) && Objects.equals(idCard, that.idCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, createdAt, dateOfBirth, firstName, lastName, nationality, oId, phoneNumber, slug, username, gender, roleId, token, idCard);
    }
}
