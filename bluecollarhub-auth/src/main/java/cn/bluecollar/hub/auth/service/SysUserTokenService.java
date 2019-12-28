package cn.bluecollar.hub.auth.service;

import cn.bluecollar.hub.common.Result;
import cn.bluecollar.hub.entity.sys.SysUserToken;

/**
 * SysUserTokenService
 *
 * @author rick
 * @date 2019/10/20 15:17
 * @description
 */
public interface SysUserTokenService {
    /**
     * 生成Token
     *
     * @param userId
     * @return
     */
    Result createToken(Integer userId);

    /**
     * 查询token
     *
     * @param token
     * @return
     */
    SysUserToken queryByToken(String token);

    /**
     * 退出登录
     *
     * @param userId
     */
    void logout(Integer userId);

    /**
     * 续期
     *
     * @param userId
     * @param token
     */
    void refreshToken(Integer userId, String token);
}
