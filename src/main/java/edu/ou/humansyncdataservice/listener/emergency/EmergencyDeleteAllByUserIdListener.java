package edu.ou.humansyncdataservice.listener.emergency;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.emergency.EmergencyDeleteAllByUserIdQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmergencyDeleteAllByUserIdListener implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> emergencyDeleteAllByUserIdRepository;

    /**
     * Delete exist emergencies of user
     *
     * @param userId user id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {EmergencyDeleteAllByUserIdQueueI.QUEUE})
    public Object execute(Integer userId) {
        return emergencyDeleteAllByUserIdRepository.execute(userId);
    }
}
