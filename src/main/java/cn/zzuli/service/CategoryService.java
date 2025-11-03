package cn.zzuli.service;

import cn.zzuli.entity.Category;

import java.util.List;

public interface CategoryService {


    /**
     * 获取所有分类
     * @return
     */
    List<Category> getCategories();
}