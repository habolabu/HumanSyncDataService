package edu.ou.humansyncdataservice.listener.user;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.user.UserDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDeleteListener implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> userDeleteRepository;

    /**
     * Delete exist user
     *
     * @param userId user id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {UserDeleteQueueI.QUEUE})
    public Object execute(Integer userId) {
        return userDeleteRepository.execute(userId);
    }
}
