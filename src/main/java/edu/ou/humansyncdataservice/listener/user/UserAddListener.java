package edu.ou.humansyncdataservice.listener.user;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.human.internal.user.UserAddQueueI;
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
public class UserAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<UserDocument, UserDocument> userAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new user
     *
     * @param input input of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {UserAddQueueI.QUEUE})
    public Object execute(Object input) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) input);
        final UserDocument userDocument = UserDocumentMapper.INSTANCE.fromMap(dataMap);

        return userAddRepository.execute(userDocument);
    }
}
