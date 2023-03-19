package edu.ou.humansyncdataservice.common.mapper;

import edu.ou.humansyncdataservice.data.entity.AvatarDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.Map;

@Mapper
public interface AvatarDocumentMapper {
    AvatarDocumentMapper INSTANCE = Mappers.getMapper(AvatarDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to Avatar object
     *
     * @param map represents for AvatarRequest object
     * @return Avatar object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "url", source = "url", qualifiedByName = "objectToString")
    @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "objectToDate")
    @Mapping(target = "selected", source = "selected", qualifiedByName = "objectToBoolean")
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    AvatarDocument fromMap(Map<String, Object> map);

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
     * Convert object to boolean
     *
     * @param object object will be converted
     * @return boolean value
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToBoolean")
    static boolean objectToBoolean(Object object) {
        return (boolean) object;
    }

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
