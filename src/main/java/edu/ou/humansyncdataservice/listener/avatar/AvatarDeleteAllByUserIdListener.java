package edu.ou.humansyncdataservice.listener.avatar;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.avatar.AvatarDeleteAllByUserIdQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AvatarDeleteAllByUserIdListener implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> avatarDeleteAllByUserIdRepository;

    /**
     * Delete exist avatars of user
     *
     * @param userId user id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {AvatarDeleteAllByUserIdQueueI.QUEUE})
    public Object execute(Integer userId) {
        return avatarDeleteAllByUserIdRepository.execute(userId);
    }

}
