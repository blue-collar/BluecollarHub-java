package cn.bluecollar.hub.portal.article.controller;


import cn.bluecollar.hub.common.Result;
import cn.bluecollar.hub.common.constants.RedisCacheNames;
import cn.bluecollar.hub.common.util.PageUtils;
import cn.bluecollar.hub.entity.article.vo.ArticleVO;
import cn.bluecollar.hub.portal.article.service.ArticleService;
import cn.bluecollar.hub.portal.common.annotation.LogLike;
import cn.bluecollar.hub.portal.common.annotation.LogView;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author rick
 * @since 2018-11-07
 */
@RestController("articlePortalController")
@CacheConfig(cacheNames = {RedisCacheNames.ARTICLE})
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/article/{articleId}")
    @LogView(type = "article")
    public Result getArticle(@PathVariable Integer articleId) {
        ArticleVO article = articleService.getArticleVo(articleId);
        return Result.ok().put("article", article);
    }

    @PutMapping("/article/like/{id}")
    @LogLike(type = "article")
    public Result likeArticle(@PathVariable Integer id) {
        return Result.ok();
    }

    @GetMapping("/articles")
    @Cacheable
    public Result list(@RequestParam Map<String, Object> params) {
        System.out.println("call articles list");
        System.out.println("123123");
        PageUtils page = articleService.queryPageCondition(params);
        return Result.ok().put("page", page);
    }


}
