package cn.bluecollar.hub.entity.article.vo;

import cn.bluecollar.hub.entity.article.Article;
import cn.bluecollar.hub.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ArticleVo
 *
 * @author rick
 * @date 2019/01/09 16:51
 * @description 文章列表VO
 */
@Data
public class ArticleVO extends Article {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

}
