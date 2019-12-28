package cn.bluecollar.hub.portal.operation.controller;

import cn.bluecollar.hub.common.Result;
import cn.bluecollar.hub.common.constants.RedisCacheNames;
import cn.bluecollar.hub.entity.operation.Link;
import cn.bluecollar.hub.portal.operation.service.LinkService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * LinkController
 *
 * @author rick
 * @date 2019/02/21 17:09
 * 
 * @description
 */
@RequestMapping("/operation")
@CacheConfig(cacheNames = RedisCacheNames.LINK)
@RestController("LinkPortalController")
public class LinkController {

    @Resource
    private LinkService linkService;

    @RequestMapping("/links")
    @Cacheable
    public Result listLink() {
        List<Link> linkList = linkService.listLink();
        return Result.ok().put("linkList",linkList);
    }
}
