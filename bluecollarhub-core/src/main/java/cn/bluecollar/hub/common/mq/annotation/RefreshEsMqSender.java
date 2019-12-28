package cn.bluecollar.hub.common.mq.annotation;

import java.lang.annotation.*;

/**
 * RefreshEsMqSender
 *
 * @author rick
 * @date 2019/03/16 22:52
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RefreshEsMqSender {
    String sender();

    String msg() default "send refresh msg to ElasticSearch";

}
