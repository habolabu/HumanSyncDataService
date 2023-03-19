package edu.ou.humansyncdataservice.repository.parkingDetail;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.humansyncdataservice.data.entity.ParkingDetailDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkingDetailAddRepository extends BaseRepository<ParkingDetailDocument, ParkingDetailDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ParkingDetailDocument input) {
        // do nothing
    }

    /**
     * Save new parking detail
     *
     * @param parkingDetailDocument parking detail
     * @return parking detail
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ParkingDetailDocument doExecute(ParkingDetailDocument parkingDetailDocument) {
        return mongoTemplate.save(parkingDetailDocument);
    }

    @Override
    protected void postExecute(ParkingDetailDocument input) {
        // do nothing
    }
}
