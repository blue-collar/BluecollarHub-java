package cn.bluecollar.hub.mapper.operation;

import cn.bluecollar.hub.entity.operation.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author rick
 * @since 2018-12-17
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询所有类别
     *
     * @param params
     * @return
     */
    List<Category> queryAll(Map<String, Object> params);
}
