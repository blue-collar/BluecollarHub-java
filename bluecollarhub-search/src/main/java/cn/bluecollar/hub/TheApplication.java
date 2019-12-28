package cn.bluecollar.hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TheApplication
 *
 * @author: rick
 * @date: 2018/10/07 10:47
 * @description: 启动类
 */
@SpringBootApplication
public class TheApplication {


    public static void main(String[] args) {
        /**
         * ElasticSearch 所需的临时设置，待解决
         */
        System.setProperty("es.set.netty.runtime.available.processors","false");
        SpringApplication.run(TheApplication.class, args);
    }
}
