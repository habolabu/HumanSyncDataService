package edu.ou.humansyncdataservice.data.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParkingDetailDocumentPK implements Serializable {
    private int parkingId;
    private int parkingTypeId;
    private int userId;
}
