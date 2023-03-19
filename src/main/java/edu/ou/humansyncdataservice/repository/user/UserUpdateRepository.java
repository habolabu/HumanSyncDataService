package edu.ou.humansyncdataservice.repository.user;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.humansyncdataservice.data.entity.UserDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserUpdateRepository extends BaseRepository<UserDocument, UserDocument> {
    private final IBaseRepository<Integer, UserDocument> userFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(UserDocument input) {
        // do nothing
    }

    /**
     * Update exist user document
     *
     * @param userDocument user
     * @return updated user
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected UserDocument doExecute(UserDocument userDocument) {
        final UserDocument existUserDocument =
                userFindOneRepository.execute(userDocument.getOId());

        assert existUserDocument != null;
        userDocument.setId(existUserDocument.getId());

        return mongoTemplate.save(userDocument);
    }

    @Override
    protected void postExecute(UserDocument input) {
        // do nothing
    }
}
