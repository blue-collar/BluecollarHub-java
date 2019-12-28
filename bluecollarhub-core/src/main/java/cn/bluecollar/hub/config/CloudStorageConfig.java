package cn.bluecollar.hub.config;


import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * CloudStorageConfig
 *
 * @author rick
 * @date 2019/10/19 18:47
 * @description 云存储配置类
 */
@Data
@Configuration
public class CloudStorageConfig implements Serializable {
    private static final long serialVersionUID = 1L;
}
