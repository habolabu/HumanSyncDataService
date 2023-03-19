package edu.ou.humansyncdataservice.listener.avatar;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.avatar.AvatarAddQueueI;
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
public class AvatarAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<AvatarDocument, AvatarDocument> avatarAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new avatar
     *
     * @param avatar avatar of avatar
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {AvatarAddQueueI.QUEUE})
    public Object execute(Object avatar) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) avatar);
        final AvatarDocument avatarDocument = AvatarDocumentMapper.INSTANCE.fromMap(dataMap);

        return avatarAddRepository.execute(avatarDocument);
    }
}
