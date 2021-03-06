package cn.bluecollar.hub.portal.article.service.impl;

import cn.bluecollar.hub.common.enums.ModuleEnum;
import cn.bluecollar.hub.common.util.PageUtils;
import cn.bluecollar.hub.common.util.Query;
import cn.bluecollar.hub.entity.article.Article;
import cn.bluecollar.hub.entity.article.vo.ArticleVO;
import cn.bluecollar.hub.manage.operation.service.TagService;
import cn.bluecollar.hub.mapper.article.ArticleMapper;
import cn.bluecollar.hub.portal.article.service.ArticleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author rick
 * @since 2018-11-07
 */
@Service("ArticlePortalService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Resource
    private TagService tagService;

    /**
     * 分页分类获取列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPageCondition(Map<String, Object> params) {
        Page<ArticleVO> page = new Query<ArticleVO>(params).getPage();
        List<ArticleVO> articleList = baseMapper.queryPageCondition(page, params);
        // 封装ArticleVo
        page.setRecords(articleList);
        return new PageUtils(page);
    }

    /**
     * 获取ArticleVo对象
     *
     * @param articleId
     * @return
     */
    @Override
    public ArticleVO getArticleVo(Integer articleId) {
        Article article = baseMapper.selectById(articleId);
        ArticleVO articleVo = new ArticleVO();
        BeanUtils.copyProperties(article,articleVo);
        articleVo.setTagList(tagService.listByLinkId(articleId,ModuleEnum.ARTICLE.getValue()));
        return articleVo;
    }

    /**
     * 获取简单的Article对象
     * @param articleId
     * @return
     */
    @Override
    public ArticleVO getSimpleArticleVo(Integer articleId) {
        ArticleVO articleVo = baseMapper.getSimpleArticleVo(articleId);
        articleVo.setTagList(tagService.listByLinkId(articleId,ModuleEnum.ARTICLE.getValue()));
        return articleVo;
    }

}
