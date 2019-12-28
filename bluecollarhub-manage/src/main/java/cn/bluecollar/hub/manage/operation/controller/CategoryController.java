package cn.bluecollar.hub.manage.operation.controller;

import cn.bluecollar.hub.common.Result;
import cn.bluecollar.hub.common.base.AbstractController;
import cn.bluecollar.hub.common.constants.RedisCacheNames;
import cn.bluecollar.hub.common.enums.CategoryRankEnum;
import cn.bluecollar.hub.common.exception.MyException;
import cn.bluecollar.hub.common.validator.ValidatorUtils;
import cn.bluecollar.hub.entity.operation.Category;
import cn.bluecollar.hub.manage.article.service.ArticleService;
import cn.bluecollar.hub.manage.operation.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rick
 * @since 2018-12-17
 */
@RestController
@CacheConfig(cacheNames = RedisCacheNames.CATEGORY)
@RequestMapping("/admin/operation/category")
public class CategoryController extends AbstractController {

    @Resource
    private CategoryService categoryService;

    @Resource
    private ArticleService articleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("operation:category:list")
    public Result list(@RequestParam Map<String, Object> params) {
        List<Category> categoryList = categoryService.queryWithParentName(params);
        return Result.ok().put("categoryList", categoryList);
    }

    /**
     * 树状列表
     */
    @RequestMapping("/select")
    @RequiresPermissions("operation:category:list")
    public Result select(Integer type) {
        List<Category> categoryList = categoryService.list(new QueryWrapper<Category>().lambda().eq(type != null, Category::getType, type));

        //添加顶级分类
        Category root = new Category();
        root.setId(-1);
        root.setName("根目录");
        root.setParentId(-1);
        categoryList.add(root);

        return Result.ok().put("categoryList", categoryList);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("operation:category:info")
    public Result info(@PathVariable("id") Integer id) {
        Category category = categoryService.getById(id);

        return Result.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("operation:category:save")
    @CacheEvict(allEntries = true)
    public Result save(@RequestBody Category category) {
        // 数据校验
        ValidatorUtils.validateEntity(category);
        verifyCategory(category);
        categoryService.save(category);

        return Result.ok();
    }

    /**
     * 数据校验
     *
     * @param category
     */
    private void verifyCategory(Category category) {
        //上级分类级别
        int parentRank = CategoryRankEnum.ROOT.getValue();
        if (category.getParentId() != CategoryRankEnum.FIRST.getValue()
                && category.getParentId() != CategoryRankEnum.ROOT.getValue()) {
            Category parentCategory = categoryService.getById(category.getParentId());
            parentRank = parentCategory.getRank();
        }

        // 一级
        if (category.getRank() == CategoryRankEnum.FIRST.getValue()) {
            if (category.getParentId() != CategoryRankEnum.ROOT.getValue()) {
                throw new MyException("上级目录只能为根目录");
            }
        }

        //二级
        if (category.getRank() == CategoryRankEnum.SECOND.getValue()) {
            if (parentRank != CategoryRankEnum.FIRST.getValue()) {
                throw new MyException("上级目录只能为一级类型");
            }
        }

        //三级
        if (category.getRank() == CategoryRankEnum.THIRD.getValue()) {
            if (parentRank != CategoryRankEnum.SECOND.getValue()) {
                throw new MyException("上级目录只能为二级类型");
            }
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("operation:category:update")
    @CacheEvict(allEntries = true)
    public Result update(@RequestBody Category category) {
        categoryService.updateById(category);

        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @RequiresPermissions("operation:category:delete")
    @CacheEvict(allEntries = true)
    public Result delete(@PathVariable Integer id) {

        //判断是否有子菜单或按钮
        List<Category> categoryList = categoryService.queryListParentId(id);
        if (categoryList.size() > 0) {
            return Result.error("请先删除子级别");
        }
        // 判断是否有文章
        if (articleService.checkByCategory(id)) {
            return Result.error("该类别下有文章，无法删除");
        }

        categoryService.removeById(id);

        return Result.ok();
    }
}
