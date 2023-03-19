package edu.ou.humansyncdataservice.repository.parkingDetail;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.humansyncdataservice.data.entity.ParkingDetailDocument;
import edu.ou.humansyncdataservice.data.entity.ParkingDetailDocumentPK;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@RequiredArgsConstructor
public class ParkingDetailDeleteRepository extends BaseRepository<ParkingDetailDocumentPK, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ParkingDetailDocumentPK input) {
        // do nothing
    }

    /**
     * Delete exist parking detail
     *
     * @param parkingDetailDocumentPK parking detail id
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(ParkingDetailDocumentPK parkingDetailDocumentPK) {
        return mongoTemplate.remove(
                new Query(
                        new Criteria().andOperator(
                                new ArrayList<Criteria>() {
                                    {
                                        add(Criteria.where("parkingId")
                                                .is(parkingDetailDocumentPK.getParkingId()));
                                        add(Criteria.where("userId")
                                                .is(parkingDetailDocumentPK.getUserId()));
                                    }
                                }.toArray(new Criteria[0])
                        )
                ),
                ParkingDetailDocument.class
        );
    }

    @Override
    protected void postExecute(ParkingDetailDocumentPK input) {
        // do nothing
    }
}
