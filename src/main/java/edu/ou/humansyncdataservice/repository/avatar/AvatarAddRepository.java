package edu.ou.humansyncdataservice.repository.avatar;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.humansyncdataservice.data.entity.AvatarDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AvatarAddRepository extends BaseRepository<AvatarDocument, AvatarDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(AvatarDocument input) {
        // do nothing
    }

    /**
     * Save new avatar
     *
     * @param avatarDocument avatar
     * @return avatar
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected AvatarDocument doExecute(AvatarDocument avatarDocument) {
        return mongoTemplate.save(avatarDocument);
    }

    @Override
    protected void postExecute(AvatarDocument input) {
        // do nothing
    }
}
