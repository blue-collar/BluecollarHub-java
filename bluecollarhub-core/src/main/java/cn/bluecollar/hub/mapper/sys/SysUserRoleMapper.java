package cn.bluecollar.hub.mapper.sys;

import cn.bluecollar.hub.entity.sys.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * SysUserRoleMapper
 *
 * @author Zoey
 * @date 2019/10/26 00:02
 * @description
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    /**
     * 查询roleId
     *
     * @param userId
     * @return
     */
    List<Integer> queryRoleIdList(Integer userId);
}
