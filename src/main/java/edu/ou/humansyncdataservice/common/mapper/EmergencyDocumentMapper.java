package edu.ou.humansyncdataservice.common.mapper;

import edu.ou.humansyncdataservice.data.entity.EmergencyDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface EmergencyDocumentMapper {
    EmergencyDocumentMapper INSTANCE = Mappers.getMapper(EmergencyDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to Emergency object
     *
     * @param map represents for EmergencyRequest object
     * @return Emergency object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "name", source = "name", qualifiedByName = "objectToString")
    @Mapping(target = "address", source = "address", qualifiedByName = "objectToString")
    @Mapping(target = "phoneNumber", source = "phoneNumber", qualifiedByName = "objectToString")
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    EmergencyDocument fromMap(Map<String, Object> map);

    /**
     * Convert object to String
     *
     * @param object object will be converted
     * @return String object
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToString")
    static String objectToString(Object object) {
        return (String) object;
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
