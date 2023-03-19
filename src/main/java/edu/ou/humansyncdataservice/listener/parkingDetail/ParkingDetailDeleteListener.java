package edu.ou.humansyncdataservice.listener.parkingDetail;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.parkingDetail.ParkingDetailDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.humansyncdataservice.common.mapper.ParkingDetailDocumentMapper;
import edu.ou.humansyncdataservice.data.entity.ParkingDetailDocumentPK;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ParkingDetailDeleteListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<ParkingDetailDocumentPK, Object> parkingDetailDeleteRepository;
    private final MessageConverter messageConverter;


    /**
     * Delete exist parking detail
     *
     * @param parkingDetail parking detail id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ParkingDetailDeleteQueueI.QUEUE})
    public Object execute(Object parkingDetail) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) parkingDetail);
        final ParkingDetailDocumentPK parkingDetailDocumentPK = ParkingDetailDocumentMapper.INSTANCE.fromMapPK(dataMap);

        return parkingDetailDeleteRepository.execute(parkingDetailDocumentPK);
    }
}
