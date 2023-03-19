package edu.ou.humansyncdataservice.repository.emergency;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.humansyncdataservice.data.entity.EmergencyDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmergencyFindOneRepository extends BaseRepository<Integer, EmergencyDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find emergency by id
     *
     * @param emergencyId emergency id
     * @return emergency
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected EmergencyDocument doExecute(Integer emergencyId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(emergencyId)
                ),
                EmergencyDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
