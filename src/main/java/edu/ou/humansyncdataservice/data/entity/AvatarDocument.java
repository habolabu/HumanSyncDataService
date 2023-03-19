package edu.ou.humansyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;


@Data
@Document("Avatar")
public class AvatarDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private Date createdAt;
    private boolean isSelected;
    private String url;
    private int userId;

}
