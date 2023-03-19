package edu.ou.humansyncdataservice.repository.avatar;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.humansyncdataservice.data.entity.AvatarDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AvatarFindAllByUserIdRepository extends BaseRepository<Integer, List<AvatarDocument>> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find user by id
     *
     * @param userId user id
     * @return avatar
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected List<AvatarDocument> doExecute(Integer userId) {
        return mongoTemplate.find(
                new Query(
                        Criteria.where("userId")
                                .is(userId)
                ),
                AvatarDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
