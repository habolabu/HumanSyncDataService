package edu.ou.humansyncdataservice.repository.roomDetail;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.humansyncdataservice.data.entity.RoomDetailDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoomDetailAddRepository extends BaseRepository<RoomDetailDocument, RoomDetailDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(RoomDetailDocument input) {
        // do nothing
    }

    /**
     * Save new room detail
     *
     * @param roomDetailDocument room detail
     * @return room detail
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected RoomDetailDocument doExecute(RoomDetailDocument roomDetailDocument) {
        return mongoTemplate.save(roomDetailDocument);
    }

    @Override
    protected void postExecute(RoomDetailDocument input) {
        // do nothing
    }
}
