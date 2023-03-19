package edu.ou.humansyncdataservice.listener.avatar;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.avatar.AvatarUpdateQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.humansyncdataservice.common.mapper.AvatarDocumentMapper;
import edu.ou.humansyncdataservice.data.entity.AvatarDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AvatarUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<AvatarDocument, AvatarDocument> avatarUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Update information exist avatar
     *
     * @param avatar avatar of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {AvatarUpdateQueueI.QUEUE})
    public Object execute(Object avatar) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) avatar);
        final AvatarDocument avatarDocument = AvatarDocumentMapper.INSTANCE.fromMap(dataMap);

        return avatarUpdateRepository.execute(avatarDocument);
    }
}
