package cn.bluecollar.hub.portal.operation.controller;

import cn.bluecollar.hub.common.Result;
import cn.bluecollar.hub.common.constants.RedisCacheNames;
import cn.bluecollar.hub.entity.operation.vo.TagVO;
import cn.bluecollar.hub.portal.operation.service.TagService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TagController
 *
 * @author rick
 * @date 2019/02/22 16:34
 * 
 * @description
 */
@RestController("tagPortalController")
@CacheConfig(cacheNames = RedisCacheNames.TAG)
@RequestMapping("/operation")
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping("/tags")
    @Cacheable
    public Result listTag() {
        List<TagVO> tagList = tagService.listTagVo();
        return Result.ok().put("tagList",tagList);
    }

}
