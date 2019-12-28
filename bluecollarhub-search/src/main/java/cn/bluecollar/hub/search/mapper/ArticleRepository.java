package cn.bluecollar.hub.search.mapper;

import cn.bluecollar.hub.entity.article.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * ArticleRepository
 *
 * @author rick
 * @date 2019/03/13 15:00
 * 
 * @description
 */
@Component
public interface ArticleRepository extends ElasticsearchRepository<Article,Integer> {
}
