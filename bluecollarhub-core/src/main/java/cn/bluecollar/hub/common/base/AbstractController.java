package cn.bluecollar.hub.common.base;

import cn.bluecollar.hub.entity.sys.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * AbstractController
 *
 * @author rick
 * @date 2019/10/22 12:35
 * @description
 */
public class AbstractController {

    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Integer getUserId() {
        return getUser().getUserId();
    }
}
