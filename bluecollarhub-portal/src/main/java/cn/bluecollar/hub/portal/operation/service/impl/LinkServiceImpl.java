package cn.bluecollar.hub.portal.operation.service.impl;

import cn.bluecollar.hub.entity.operation.Link;
import cn.bluecollar.hub.mapper.operation.LinkMapper;
import cn.bluecollar.hub.portal.operation.service.LinkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * LinkService
 *
 * @author rick
 * @date 2019/02/21 17:10
 * 
 * @description
 */
@Service("linkPortalService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {


    /**
     * 获取link列表
     *
     * @return
     */
    @Override
    public List<Link> listLink() {
        return baseMapper.selectList(null);
    }
}
