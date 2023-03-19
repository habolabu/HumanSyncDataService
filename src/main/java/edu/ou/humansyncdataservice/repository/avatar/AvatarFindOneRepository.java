package edu.ou.humansyncdataservice.repository.avatar;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.humansyncdataservice.data.entity.AvatarDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AvatarFindOneRepository extends BaseRepository<Integer, AvatarDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find avatar by id
     *
     * @param avatarId avatar id
     * @return avatar
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected AvatarDocument doExecute(Integer avatarId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(avatarId)
                ),
                AvatarDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
