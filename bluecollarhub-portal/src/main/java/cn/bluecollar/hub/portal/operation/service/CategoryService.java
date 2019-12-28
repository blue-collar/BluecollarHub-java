package cn.bluecollar.hub.portal.operation.service;

import cn.bluecollar.hub.entity.operation.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * CategoryService
 *
 * @author rick
 * @date 2019/02/19 15:33
 * 
 * @description
 */
public interface CategoryService extends IService<Category> {

    /**
     * 获取categoryList
     * @param params
     * @return
     */
    List<Category> listCategory(Map<String, Object> params);
}
