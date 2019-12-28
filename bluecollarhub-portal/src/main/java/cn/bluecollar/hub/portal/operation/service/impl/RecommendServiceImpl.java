package cn.bluecollar.hub.portal.operation.service.impl;

import cn.bluecollar.hub.common.enums.ModuleEnum;
import cn.bluecollar.hub.entity.article.vo.ArticleVO;
import cn.bluecollar.hub.entity.operation.Recommend;
import cn.bluecollar.hub.entity.operation.vo.RecommendVO;
import cn.bluecollar.hub.manage.operation.mapper.RecommendMapper;
import cn.bluecollar.hub.portal.article.service.ArticleService;
import cn.bluecollar.hub.portal.operation.service.RecommendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * RecommendServiceImpl
 *
 * @author rick
 * @date 2019/02/22 13:42
 * @description
 */
@Service("recommendPortalService")
public class RecommendServiceImpl extends ServiceImpl<RecommendMapper, Recommend> implements RecommendService {

    @Resource
    private ArticleService articleService;

    @Override
    public List<RecommendVO> listRecommendVo() {
        List<RecommendVO> recommendList = this.baseMapper.listRecommendVo();
        return genRecommendList(recommendList);
    }

    @Override
    public List<RecommendVO> listHotRead() {
        List<RecommendVO> hotReadList = this.baseMapper.listHotRead();
        genRecommendList(hotReadList);
        if (0 < hotReadList.size()) {
            hotReadList.get(0).setTop(true);
        }
        return hotReadList;
    }

    private List<RecommendVO> genRecommendList(List<RecommendVO> recommendList) {
        recommendList.forEach(recommendVo -> {
            if (ModuleEnum.ARTICLE.getValue() == recommendVo.getType()) {
                ArticleVO simpleArticleVo = articleService.getSimpleArticleVo(recommendVo.getLinkId());
                BeanUtils.copyProperties(simpleArticleVo, recommendVo);
                recommendVo.setUrlType("article");
            }
        });
        return recommendList;
    }
}
