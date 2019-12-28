package cn.bluecollar.hub.portal.operation.service.impl;

import cn.bluecollar.hub.entity.operation.Category;
import cn.bluecollar.hub.mapper.operation.CategoryMapper;
import cn.bluecollar.hub.portal.operation.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * CategoryServiceImpl
 *
 * @author rick
 * @date 2019/02/19 15:33
 * 
 * @description
 */
@Service("categoryPortalService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    /**
     * 获取categoryList
     *
     * @param params
     * @return
     */
    @Override
    public List<Category> listCategory(Map<String, Object> params) {
        System.out.println("call listCategory 01");
        String type = (String) params.get("type");
        String rank = (String) params.get("rank");
        return baseMapper.selectList(new QueryWrapper<Category>().lambda()
                .eq(StringUtils.isNotEmpty(type),Category::getType,type)
                .eq(StringUtils.isNotEmpty(rank),Category::getRank,rank));
    }
}
