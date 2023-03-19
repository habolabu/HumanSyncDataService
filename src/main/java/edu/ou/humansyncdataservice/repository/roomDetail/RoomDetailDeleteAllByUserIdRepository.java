package edu.ou.humansyncdataservice.repository.roomDetail;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.humansyncdataservice.data.entity.RoomDetailDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoomDetailDeleteAllByUserIdRepository extends BaseRepository<Integer, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Delete exist room detail
     *
     * @param userId user id
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(Integer userId) {
        return mongoTemplate.remove(
                new Query(
                        Criteria.where("userId")
                                .is(userId)
                ),
                RoomDetailDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
