package cn.bluecollar.hub.portal.operation.service;

import cn.bluecollar.hub.entity.operation.Link;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * LinkService
 *
 * @author rick
 * @date 2019/02/21 17:09
 * 
 * @description
 */
public interface LinkService extends IService<Link> {

    /**
     * 获取link列表
     * @return
     */
    List<Link> listLink();
}
