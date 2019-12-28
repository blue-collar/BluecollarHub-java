package cn.bluecollar.hub.mapper.sys;

import cn.bluecollar.hub.entity.sys.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author rick
 * @since 2018-10-08
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     * 根据roleId查询所属menuId
     *
     * @param roleId
     * @return
     */
    List<Integer> queryMenuIdList(Integer roleId);
}
