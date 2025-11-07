package cn.zzuli.service;

import cn.zzuli.entity.Category;

import java.util.List;

public interface CategoryService {


    /**
     * 获取所有分类
     * @return
     */
    List<Category> getAllCategories();

    /**
     * 获取分类树
     * @return
     */
    List<Category> getCategoryTree();

    /**
     * 保存分类
     * @param category
     */
    void saveCategory(Category category);

    /**
     * 修改分类
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 删除分类
     * @param id
     */
    void deleteCategory(Long id);
}