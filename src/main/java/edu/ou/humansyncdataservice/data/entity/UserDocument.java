package edu.ou.humansyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document("User")
public class UserDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private String address;
    private int gender;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private String nationality;
    private String idCard;
    private String phoneNumber;
    private String email;
    private Date createdAt;
    private String keyCloakId;
}
