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
public class EmergencyDeleteRepository extends BaseRepository<Integer, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Delete exist emergency
     *
     * @param emergencyId emergency id
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(Integer emergencyId) {
        return mongoTemplate.remove(
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
