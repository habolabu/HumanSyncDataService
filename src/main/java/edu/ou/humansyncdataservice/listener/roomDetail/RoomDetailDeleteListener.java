package edu.ou.humansyncdataservice.listener.roomDetail;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.roomDetail.RoomDetailDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.humansyncdataservice.common.mapper.RoomDetailDocumentMapper;
import edu.ou.humansyncdataservice.data.entity.RoomDetailDocumentPK;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class RoomDetailDeleteListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<RoomDetailDocumentPK, Object> parkingDetailDeleteRepository;
    private final MessageConverter messageConverter;

    /**
     * Delete exist room detail
     *
     * @param roomDetail room detail id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {RoomDetailDeleteQueueI.QUEUE})
    public Object execute(Object roomDetail) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) roomDetail);
        final RoomDetailDocumentPK roomDetailDocumentPK = RoomDetailDocumentMapper.INSTANCE.fromMapPK(dataMap);

        return parkingDetailDeleteRepository.execute(roomDetailDocumentPK);
    }
}
