package cn.bluecollar.hub.entity.article.dto;

import cn.bluecollar.hub.entity.article.Article;
import cn.bluecollar.hub.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ArticleDto
 *
 * @author rick
 * @date 2019/01/08 19:04
 * @description
 */
@Data
public class ArticleDTO extends Article {

    private List<Tag> tagList;

}
