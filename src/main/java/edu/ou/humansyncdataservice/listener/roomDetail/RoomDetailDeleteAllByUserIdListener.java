package edu.ou.humansyncdataservice.listener.roomDetail;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.roomDetail.RoomDetailDeleteAllByUserIdQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomDetailDeleteAllByUserIdListener implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> roomDetailDeleteAllByUserIdRepository;

    /**
     * Delete exist room details of user
     *
     * @param userId user id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {RoomDetailDeleteAllByUserIdQueueI.QUEUE})
    public Object execute(Integer userId) {
        return roomDetailDeleteAllByUserIdRepository.execute(userId);
    }

}
