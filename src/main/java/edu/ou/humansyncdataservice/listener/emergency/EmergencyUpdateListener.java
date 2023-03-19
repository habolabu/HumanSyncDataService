package edu.ou.humansyncdataservice.listener.emergency;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.emergency.EmergencyUpdateQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.humansyncdataservice.common.mapper.EmergencyDocumentMapper;
import edu.ou.humansyncdataservice.data.entity.EmergencyDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmergencyUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<EmergencyDocument, EmergencyDocument> emergencyUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Update information exist emergency
     *
     * @param emergency emergency of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {EmergencyUpdateQueueI.QUEUE})
    public Object execute(Object emergency) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) emergency);
        final EmergencyDocument emergencyDocument = EmergencyDocumentMapper.INSTANCE.fromMap(dataMap);

        return emergencyUpdateRepository.execute(emergencyDocument);
    }
}
