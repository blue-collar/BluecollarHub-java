package cn.bluecollar.hub.mapper.operation;

import cn.bluecollar.hub.entity.operation.TagLink;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章标签多对多维护表 Mapper 接口
 * </p>
 *
 * @author rick
 * @since 2019-01-07
 */
@Mapper
public interface TagLinkMapper extends BaseMapper<TagLink> {

}
