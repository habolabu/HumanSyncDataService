package edu.ou.humansyncdataservice.listener.roomDetail;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.roomDetail.RoomDetailAddQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.humansyncdataservice.common.mapper.RoomDetailDocumentMapper;
import edu.ou.humansyncdataservice.data.entity.RoomDetailDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class RoomDetailAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<RoomDetailDocument, RoomDetailDocument> roomDetailAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new room detail
     *
     * @param roomDetail roomDetail of room detail
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {RoomDetailAddQueueI.QUEUE})
    public Object execute(Object roomDetail) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) roomDetail);
        final RoomDetailDocument roomDetailDocument = RoomDetailDocumentMapper.INSTANCE.fromMap(dataMap);

        return roomDetailAddRepository.execute(roomDetailDocument);
    }
}
