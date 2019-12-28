package cn.bluecollar.hub.common.util;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RabbitMqUtils
 *
 * @author rick
 * @date 2019/03/16 22:08
 * @description
 */
@Component
public class RabbitMqUtils {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送到指定Queue
     *
     * @param queueName
     * @param obj
     */
    public void send(String queueName, Object obj) {
        this.rabbitTemplate.convertAndSend(queueName, obj);
    }
}
