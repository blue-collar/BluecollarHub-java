package cn.bluecollar.hub.config;

import cn.bluecollar.hub.common.constants.RabbitMqConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * RabbitMQConfig
 *
 * @author rick
 * @date 2019/03/16 21:59
 * @description
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue() {
        return new Queue(RabbitMqConstants.REFRESH_ES_INDEX_QUEUE);
    }
}
