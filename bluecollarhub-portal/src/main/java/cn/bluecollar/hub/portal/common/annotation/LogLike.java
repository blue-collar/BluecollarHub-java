package cn.bluecollar.hub.portal.common.annotation;

import java.lang.annotation.*;

/**
 * ViewLog
 *
 * @author rick
 * @date 2019/02/15 14:51
 * 
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogLike {

     String type();
}
