package edu.ou.humansyncdataservice.listener.user;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.user.UserUpdateQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import edu.ou.humansyncdataservice.common.mapper.UserDocumentMapper;
import edu.ou.humansyncdataservice.data.entity.UserDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class UserUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<UserDocument, UserDocument> userUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Update information exist user
     *
     * @param user user of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {UserUpdateQueueI.QUEUE})
    public Object execute(Object user) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) user);
        final UserDocument userDocument = UserDocumentMapper.INSTANCE.fromMap(dataMap);

        return userUpdateRepository.execute(userDocument);
    }
}
