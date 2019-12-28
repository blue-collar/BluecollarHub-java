package cn.bluecollar.hub.manage.operation.service;

import cn.bluecollar.hub.common.util.PageUtils;
import cn.bluecollar.hub.entity.operation.Link;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 友链 服务类
 * </p>
 *
 * @author rick
 * @since 2019-02-14
 */
public interface LinkService extends IService<Link> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);
}
