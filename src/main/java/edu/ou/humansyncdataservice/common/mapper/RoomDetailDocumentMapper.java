package edu.ou.humansyncdataservice.common.mapper;

import edu.ou.humansyncdataservice.data.entity.RoomDetailDocument;
import edu.ou.humansyncdataservice.data.entity.RoomDetailDocumentPK;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.Map;

@Mapper
public interface RoomDetailDocumentMapper {
    RoomDetailDocumentMapper INSTANCE = Mappers.getMapper(RoomDetailDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to ParkingDetail object
     *
     * @param map represents for ParkingDetailRequest object
     * @return ParkingDetail object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roomId", source = "roomId", qualifiedByName = "objectToInt")
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    @Mapping(target = "joinDate", source = "joinDate", qualifiedByName = "objectToDate")
    RoomDetailDocument fromMap(Map<String, Object> map);

    /**
     * Map Map<String, Object> object to RoomDetailDocumentPK object
     *
     * @param map represents for RoomDetailDocumentPK object
     * @return RoomDetailDocumentPK object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "roomId", source = "roomId", qualifiedByName = "objectToInt")
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    RoomDetailDocumentPK fromMapPK(Map<String, Object> map);

    /**
     * Convert object to Date
     *
     * @param object object will be converted
     * @return Date object
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToDate")
    static Date objectToDate(Object object) {
        return new Date((long) object);
    }

    /**
     * Convert object to int
     *
     * @param object object will be converted
     * @return int value
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToInt")
    static int objectToInt(Object object) {
        return (int) object;
    }
}
