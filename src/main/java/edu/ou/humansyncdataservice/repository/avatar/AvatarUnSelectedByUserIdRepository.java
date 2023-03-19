package edu.ou.humansyncdataservice.repository.avatar;


import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.humansyncdataservice.data.entity.AvatarDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AvatarUnSelectedByUserIdRepository extends BaseRepository<Integer, Object> {
    private final IBaseRepository<Integer, List<AvatarDocument>> avatarFindAllByUserIdRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Update exist avatar document
     *
     * @param userId avatar
     * @return updated avatar
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(Integer userId) {
        final List<AvatarDocument> existAvatarDocuments =
                avatarFindAllByUserIdRepository.execute(userId);

        existAvatarDocuments.forEach(avatarDocument -> {
            avatarDocument.setSelected(false);
            mongoTemplate.save(avatarDocument);
        });

        return null;
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
