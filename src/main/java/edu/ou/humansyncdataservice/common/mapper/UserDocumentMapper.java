package edu.ou.humansyncdataservice.common.mapper;

import edu.ou.humansyncdataservice.data.entity.UserDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.Map;

@Mapper
public interface UserDocumentMapper {
    UserDocumentMapper INSTANCE = Mappers.getMapper(UserDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to User object
     *
     * @param map represents for UserAddRequest object
     * @return User object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "address", source = "address", qualifiedByName = "objectToString")
    @Mapping(target = "firstName", source = "firstName", qualifiedByName = "objectToString")
    @Mapping(target = "lastName", source = "lastName", qualifiedByName = "objectToString")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth", qualifiedByName = "objectToDate")
    @Mapping(target = "nationality", source = "nationality", qualifiedByName = "objectToString")
    @Mapping(target = "idCard", source = "idCard", qualifiedByName = "objectToString")
    @Mapping(target = "phoneNumber", source = "phoneNumber", qualifiedByName = "objectToString")
    @Mapping(target = "email", source = "email", qualifiedByName = "objectToString")
    @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "objectToDate")
    @Mapping(target = "gender", source = "gender", qualifiedByName = "booleanToInt")
    @Mapping(target = "keyCloakId", source = "keyCloakId", qualifiedByName = "objectToString")
    UserDocument fromMap(Map<String, Object> map);

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

    /**
     * Convert boolean to int
     *
     * @param object boolean object will be coverted
     * @return int value
     * @author Nguyen Trung Kien - OU
     */
    @Named("booleanToInt")
    static int booleanToInt(Object object) {
        return (boolean) object ? 1 : 0;
    }
}
