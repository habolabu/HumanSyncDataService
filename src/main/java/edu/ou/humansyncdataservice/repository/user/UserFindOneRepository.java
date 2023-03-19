package edu.ou.humansyncdataservice.repository.user;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.humansyncdataservice.data.entity.UserDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserFindOneRepository extends BaseRepository<Integer, UserDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find apartment by id
     *
     * @param userId apartment id
     * @return apartment
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected UserDocument doExecute(Integer userId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(userId)
                ),
                UserDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
