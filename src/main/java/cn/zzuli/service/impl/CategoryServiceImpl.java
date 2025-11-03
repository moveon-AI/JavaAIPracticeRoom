package cn.zzuli.service.impl;


import cn.zzuli.entity.Category;
import cn.zzuli.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {


    /**
     * 获取所有分类
     *
     * @return
     */
    @Override
    public List<Category> getCategories() {
        return List.of();
    }
}