package cn.bluecollar.hub.manage.operation.service;

import cn.bluecollar.hub.common.util.PageUtils;
import cn.bluecollar.hub.entity.operation.Recommend;
import cn.bluecollar.hub.entity.operation.vo.RecommendVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 推荐 服务类
 * </p>
 *
 * @author rick
 * @since 2019-02-22
 */
public interface RecommendService extends IService<Recommend> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取推荐列表
     * @return
     */
    List<RecommendVO> listSelect();

    /**
     * 更新置顶状态
     * @param id
     */
    void updateTop(Integer id);

    /**
     * 批量删除
     * @param articleIds
     * @param value
     */
    void deleteBatchByLinkId(Integer[] articleIds, int value);
}
