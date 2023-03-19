package edu.ou.humansyncdataservice.listener.emergency;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.emergency.EmergencyAddQueueI;
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
public class EmergencyAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<EmergencyDocument, EmergencyDocument> emergencyAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new emergency
     *
     * @param input input of emergency
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {EmergencyAddQueueI.QUEUE})
    public Object execute(Object input) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) input);
        final EmergencyDocument emergencyDocument = EmergencyDocumentMapper.INSTANCE.fromMap(dataMap);

        return emergencyAddRepository.execute(emergencyDocument);
    }

}
