package edu.ou.humansyncdataservice.repository.roomDetail;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.humansyncdataservice.data.entity.RoomDetailDocument;
import edu.ou.humansyncdataservice.data.entity.RoomDetailDocumentPK;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@RequiredArgsConstructor
public class RoomDetailDeleteRepository extends BaseRepository<RoomDetailDocumentPK, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(RoomDetailDocumentPK input) {
        // do nothing
    }

    /**
     * Delete exist room detail
     *
     * @param roomDetailDocumentPK room detail id
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(RoomDetailDocumentPK roomDetailDocumentPK) {
        return mongoTemplate.remove(
                new Query(
                        new Criteria().andOperator(
                                new ArrayList<Criteria>() {
                                    {
                                        add(Criteria.where("roomId")
                                                .is(roomDetailDocumentPK.getRoomId()));
                                        add(Criteria.where("userId")
                                                .is(roomDetailDocumentPK.getUserId()));
                                    }
                                }.toArray(new Criteria[0])
                        )
                ),
                RoomDetailDocument.class
        );
    }

    @Override
    protected void postExecute(RoomDetailDocumentPK input) {
        // do nothing
    }
}
