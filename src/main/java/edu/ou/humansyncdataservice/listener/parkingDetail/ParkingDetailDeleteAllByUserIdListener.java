package edu.ou.humansyncdataservice.listener.parkingDetail;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.parkingDetail.ParkingDetailDeleteAllByUserIdQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParkingDetailDeleteAllByUserIdListener implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> parkingDetailDeleteAllByUserIdRepository;

    /**
     * Delete exist parking details of user
     *
     * @param userId user id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ParkingDetailDeleteAllByUserIdQueueI.QUEUE})
    public Object execute(Integer userId) {
        return parkingDetailDeleteAllByUserIdRepository.execute(userId);
    }
}
