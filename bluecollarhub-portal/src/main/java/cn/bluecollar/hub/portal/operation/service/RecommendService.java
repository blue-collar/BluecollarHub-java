package cn.bluecollar.hub.portal.operation.service;

import cn.bluecollar.hub.entity.operation.Recommend;
import cn.bluecollar.hub.entity.operation.vo.RecommendVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * RecommendService
 *
 * @author rick
 * @date 2019/02/22 13:41
 * 
 * @description
 */
public interface RecommendService extends IService<Recommend> {

    List<RecommendVO> listRecommendVo();

    List<RecommendVO> listHotRead();
}
