package cn.bluecollar.hub.entity.sys.form;

import lombok.Data;

/**
 * SysLoginForm
 *
 * @author rick
 * @date 2019/10/20 14:51
 * @description 登录表单对象
 */
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String captcha;
    private String uuid;
}
