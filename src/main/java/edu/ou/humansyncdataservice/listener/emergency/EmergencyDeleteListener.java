package edu.ou.humansyncdataservice.listener.emergency;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.emergency.EmergencyDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmergencyDeleteListener implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> emergencyDeleteRepository;

    /**
     * Delete exist emergency
     *
     * @param emergencyId emergency id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {EmergencyDeleteQueueI.QUEUE})
    public Object execute(Integer emergencyId) {
        return emergencyDeleteRepository.execute(emergencyId);
    }
}
