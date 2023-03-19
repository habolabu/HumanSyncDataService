package edu.ou.humansyncdataservice.listener.avatar;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.avatar.AvatarDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AvatarDeleteListener implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> avatarDeleteRepository;

    /**
     * Delete exist avatar
     *
     * @param avatarId avatar id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {AvatarDeleteQueueI.QUEUE})
    public Object execute(Integer avatarId) {
        return avatarDeleteRepository.execute(avatarId);
    }
}
