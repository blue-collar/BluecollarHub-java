package cn.bluecollar.hub.portal.operation.service.impl;

import cn.bluecollar.hub.entity.operation.Tag;
import cn.bluecollar.hub.entity.operation.vo.TagVO;
import cn.bluecollar.hub.mapper.operation.TagMapper;
import cn.bluecollar.hub.portal.operation.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TagServiceImpl
 *
 * @author rick
 * @date 2019/02/22 16:34
 * 
 * @description
 */
@Service("TagPortalService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {


    /**
     * 获取tagVoList
     *
     * @return
     */
    @Override
    public List<TagVO> listTagVo() {
        return baseMapper.listTagVo();
    }
}
