package cn.bluecollar.hub.portal.article.service;


import cn.bluecollar.hub.common.util.PageUtils;
import cn.bluecollar.hub.entity.article.Article;
import cn.bluecollar.hub.entity.article.vo.ArticleVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 * @author rick
 * @since 2018-11-07
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页分类获取列表
     * @param params
     * @return
     */
    PageUtils queryPageCondition(Map<String, Object> params);

    /**
     * 获取ArticleVo对象
     * @param articleId
     * @return
     */
    ArticleVO getArticleVo(Integer articleId);

    /**
     * 获取简单的Article对象
     * @param articleId
     * @return
     */
     ArticleVO getSimpleArticleVo(Integer articleId);

}
