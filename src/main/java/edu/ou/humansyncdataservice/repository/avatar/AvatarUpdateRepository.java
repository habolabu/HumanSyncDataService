package edu.ou.humansyncdataservice.repository.avatar;

import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.humansyncdataservice.data.entity.AvatarDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AvatarUpdateRepository extends BaseRepository<AvatarDocument, AvatarDocument> {
    private final IBaseRepository<Integer, AvatarDocument> avatarFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(AvatarDocument input) {
        // do nothing
    }

    /**
     * Update exist avatar document
     *
     * @param avatarDocument avatar
     * @return updated avatar
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected AvatarDocument doExecute(AvatarDocument avatarDocument) {
        final AvatarDocument existAvatarDocument =
                avatarFindOneRepository.execute(avatarDocument.getOId());

        assert existAvatarDocument != null;
        avatarDocument.setId(existAvatarDocument.getId());

        return mongoTemplate.save(avatarDocument);
    }

    @Override
    protected void postExecute(AvatarDocument input) {
        // do nothing
    }
}
