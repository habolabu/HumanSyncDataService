package edu.ou.humansyncdataservice.data.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoomDetailDocumentPK implements Serializable {
    private int roomId;
    private int userId;
}
