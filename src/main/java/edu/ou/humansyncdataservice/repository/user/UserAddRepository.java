package edu.ou.humansyncdataservice.repository.user;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.humansyncdataservice.data.entity.UserDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserAddRepository extends BaseRepository<UserDocument, UserDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(UserDocument input) {
        // do nothing
    }

    /**
     * Save new user
     *
     * @param userDocument user
     * @return user
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected UserDocument doExecute(UserDocument userDocument) {
        return mongoTemplate.save(userDocument);
    }

    @Override
    protected void postExecute(UserDocument input) {
        // do nothing
    }
}
