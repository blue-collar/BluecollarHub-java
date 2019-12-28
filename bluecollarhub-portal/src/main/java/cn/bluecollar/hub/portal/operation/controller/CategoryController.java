package cn.bluecollar.hub.portal.operation.controller;

import cn.bluecollar.hub.common.Result;
import cn.bluecollar.hub.common.constants.RedisCacheNames;
import cn.bluecollar.hub.entity.operation.Category;
import cn.bluecollar.hub.portal.operation.service.CategoryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * CategoryController
 *
 * @author rick
 * @date 2019/02/19 15:28
 * 
 * @description
 */
@RestController("categoryPortalController")
@CacheConfig(cacheNames = RedisCacheNames.CATEGORY)
@RequestMapping("/operation")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/categories")
    @Cacheable
    public Result listCategory(@RequestParam Map<String,Object> params) {
        List<Category> categoryList = categoryService.listCategory(params);
        System.out.println("call listCategory categoryList is "+categoryList.toString());
        return Result.ok().put("categoryList",categoryList);
    }

}
