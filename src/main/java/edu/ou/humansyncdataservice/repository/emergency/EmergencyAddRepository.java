package edu.ou.humansyncdataservice.repository.emergency;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.humansyncdataservice.data.entity.EmergencyDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmergencyAddRepository extends BaseRepository<EmergencyDocument, EmergencyDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(EmergencyDocument input) {
        // do nothing
    }

    /**
     * Save new emergency
     *
     * @param emergencyDocument emergency
     * @return emergency
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected EmergencyDocument doExecute(EmergencyDocument emergencyDocument) {
        return mongoTemplate.save(emergencyDocument);
    }

    @Override
    protected void postExecute(EmergencyDocument input) {
        // do nothing
    }
}
