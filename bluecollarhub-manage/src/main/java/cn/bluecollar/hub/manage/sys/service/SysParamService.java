package cn.bluecollar.hub.manage.sys.service;

import cn.bluecollar.hub.common.util.PageUtils;
import cn.bluecollar.hub.entity.sys.SysParam;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 系统参数 服务类
 * </p>
 *
 * @author rick
 * @since 2018-12-28
 */
public interface SysParamService extends IService<SysParam> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);
}
