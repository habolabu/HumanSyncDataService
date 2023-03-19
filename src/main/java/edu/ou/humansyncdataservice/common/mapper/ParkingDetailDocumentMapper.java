package edu.ou.humansyncdataservice.common.mapper;

import edu.ou.humansyncdataservice.data.entity.ParkingDetailDocument;
import edu.ou.humansyncdataservice.data.entity.ParkingDetailDocumentPK;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.Map;

@Mapper
public interface ParkingDetailDocumentMapper {
    ParkingDetailDocumentMapper INSTANCE = Mappers.getMapper(ParkingDetailDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to ParkingDetail object
     *
     * @param map represents for ParkingDetailRequest object
     * @return ParkingDetail object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parkingId", source = "parkingId", qualifiedByName = "objectToInt")
    @Mapping(target = "parkingTypeId", source = "parkingTypeId", qualifiedByName = "objectToInt")
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    @Mapping(target = "joinDate", source = "joinDate", qualifiedByName = "objectToDate")
    ParkingDetailDocument fromMap(Map<String, Object> map);

    /**
     * Map Map<String, Object> object to ParkingDetailDocumentPK object
     *
     * @param map represents for ParkingDetailDocumentPK object
     * @return ParkingDetailDocumentPK object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "parkingId", source = "parkingId", qualifiedByName = "objectToInt")
    @Mapping(target = "parkingTypeId", source = "parkingTypeId", qualifiedByName = "objectToInt")
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    ParkingDetailDocumentPK fromMapPK(Map<String, Object> map);

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
