package edu.ou.humansyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("Emergency")
public class EmergencyDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private String name;
    private String address;
    private String phoneNumber;
    private int userId;

}
