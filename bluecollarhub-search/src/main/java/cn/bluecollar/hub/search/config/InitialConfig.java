package cn.bluecollar.hub.search.config;

import cn.bluecollar.hub.common.constants.RabbitMqConstants;
import cn.bluecollar.hub.common.util.RabbitMqUtils;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * InitialConfig
 *
 * @author rick
 * @date 2019/03/16 23:04
 * 
 * @description
 */
@Configuration
public class InitialConfig {

    @Resource
    private RabbitMqUtils rabbitMqUtils;

    /**
     * 项目启动时重新导入索引
     */
    @PostConstruct
    public void initEsIndex(){
        rabbitMqUtils.send(RabbitMqConstants.REFRESH_ES_INDEX_QUEUE,"bluecollarhub-search init index");
    }
}
