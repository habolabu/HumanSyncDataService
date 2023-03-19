package edu.ou.humansyncdataservice.repository.emergency;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.humansyncdataservice.data.entity.EmergencyDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmergencyUpdateRepository extends BaseRepository<EmergencyDocument, EmergencyDocument> {
    private final IBaseRepository<Integer, EmergencyDocument> emergencyFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(EmergencyDocument input) {
        // do nothing
    }

    /**
     * Update exist emergency document
     *
     * @param emergencyDocument emergency
     * @return updated emergency
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected EmergencyDocument doExecute(EmergencyDocument emergencyDocument) {
        final EmergencyDocument existEmergencyDocument =
                emergencyFindOneRepository.execute(emergencyDocument.getOId());

        assert existEmergencyDocument != null;
        emergencyDocument.setId(existEmergencyDocument.getId());

        return mongoTemplate.save(emergencyDocument);
    }

    @Override
    protected void postExecute(EmergencyDocument input) {
        // do nothing
    }
}
