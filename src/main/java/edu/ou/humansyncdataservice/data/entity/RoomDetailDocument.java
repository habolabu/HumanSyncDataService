package edu.ou.humansyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document("RoomDetail")
public class RoomDetailDocument implements Serializable {
    @Id
    private String id;
    private int roomId;
    private int userId;
    private Date joinDate;

}
