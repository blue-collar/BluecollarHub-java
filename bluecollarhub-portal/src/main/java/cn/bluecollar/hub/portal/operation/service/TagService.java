package cn.bluecollar.hub.portal.operation.service;

import cn.bluecollar.hub.entity.operation.Tag;
import cn.bluecollar.hub.entity.operation.vo.TagVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * TagService
 *
 * @author rick
 * @date 2019/02/22 16:34
 * 
 * @description
 */
public interface TagService extends IService<Tag> {

    /**
     * 获取tagVoList
     * @return
     */
    List<TagVO> listTagVo();
}
