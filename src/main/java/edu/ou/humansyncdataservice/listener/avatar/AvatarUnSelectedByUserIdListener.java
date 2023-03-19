package edu.ou.humansyncdataservice.listener.avatar;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.avatar.AvatarUnSelectedByUserIdQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AvatarUnSelectedByUserIdListener implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> avatarUnSelectedByUserIdRepository;

    /**
     * un selected exist avatar by userId
     *
     * @param userId input of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {AvatarUnSelectedByUserIdQueueI.QUEUE})
    public Object execute(Integer userId) {
        return avatarUnSelectedByUserIdRepository.execute(userId);
    }

}
