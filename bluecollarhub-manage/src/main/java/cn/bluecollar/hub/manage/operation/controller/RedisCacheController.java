package cn.bluecollar.hub.manage.operation.controller;

import cn.bluecollar.hub.common.Result;
import cn.bluecollar.hub.common.constants.RedisCacheNames;
import cn.bluecollar.hub.common.util.RedisUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Set;

/**
 * RedisCacheController
 *
 * @author rick
 * @date 2019/11/12 20:25
 * 
 * @description
 */
@RestController
@RequestMapping("/admin/operation/redis")
public class RedisCacheController {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;
}
