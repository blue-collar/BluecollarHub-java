package cn.bluecollar.hub.manage.article.service;

import cn.bluecollar.hub.common.util.PageUtils;
import cn.bluecollar.hub.entity.article.Article;
import cn.bluecollar.hub.entity.article.dto.ArticleDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * ArticleService
 *
 * @author rick
 * @date 2019/11/21 12:47
 * 
 * @description
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页查询博文列表
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存博文文章
     * @param article
     */
    void saveArticle(ArticleDTO article);

    /**
     * 批量删除
     * @param articleIds
     */
    void deleteBatch(Integer[] articleIds);

    /**
     * 更新博文
     * @param article
     */
    void updateArticle(ArticleDTO article);

    /**
     * 获取文章对象
     * @param articleId
     * @return
     */
    ArticleDTO getArticle(Integer articleId);


    boolean checkByCategory(Integer id);
}
