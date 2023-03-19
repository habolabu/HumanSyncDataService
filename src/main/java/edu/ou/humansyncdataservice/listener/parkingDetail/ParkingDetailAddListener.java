package edu.ou.humansyncdataservice.listener.parkingDetail;


import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.parkingDetail.ParkingDetailAddQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.humansyncdataservice.common.mapper.ParkingDetailDocumentMapper;
import edu.ou.humansyncdataservice.data.entity.ParkingDetailDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ParkingDetailAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<ParkingDetailDocument, ParkingDetailDocument> parkingDetailAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new parking detail
     *
     * @param emergency emergency of parking detail
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ParkingDetailAddQueueI.QUEUE})
    public Object execute(Object emergency) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) emergency);
        final ParkingDetailDocument parkingDetailDocument = ParkingDetailDocumentMapper.INSTANCE.fromMap(dataMap);

        return parkingDetailAddRepository.execute(parkingDetailDocument);
    }
}
