package cn.zzuli.mapper;


import cn.zzuli.entity.Question;
import cn.zzuli.vo.QuestionPageVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 题目Mapper接口
 * 继承MyBatis Plus的BaseMapper，提供基础的CRUD操作
 */
public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * 获取所有分类下的题目数量
     * @return
     */
    @Select("SELECT category_id AS id, COUNT(1) AS count FROM questions GROUP BY category_id")
    List<Map<Long, Object>> getCategoryQuestionCount();

    /**
     * 自定义分页查询
     */
    IPage<Question> customPage(IPage page, @Param("queryVo") QuestionPageVo questionQueryVo);

    /**
     * 自定义查询单个题目
     */
    Question customGetById(Long id);
}