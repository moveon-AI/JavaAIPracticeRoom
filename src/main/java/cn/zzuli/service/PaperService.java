package cn.zzuli.service;

import cn.zzuli.entity.Paper;
import cn.zzuli.vo.AiPaperVo;
import cn.zzuli.vo.PaperVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 试卷服务接口
 */
public interface PaperService extends IService<Paper> {

    /**
     * 手动组卷
     * @param paperVo
     * @return
     */
    Paper customCreatePaper(PaperVo paperVo);

    /**
     * 智能组卷
     * @param aiPaperVo
     * @return
     */
    Paper customAiCreatePaper(AiPaperVo aiPaperVo);

    /**
     * 更新试卷内信息
     * @param id
     * @param paperVo
     * @return
     */
    Paper customUpdatePaper(Integer id, PaperVo paperVo);

    /**
     * 根据试卷id试卷详情
     *    试卷对象
     *    题目集合
     *    注意： 题目的选项sort正序
     *    注意： 所有题目根据类型排序
     * @param id 试卷id
     * @return
     */
    Paper customPaperDetailById(Long id);

    /**
     * 删除试卷
     * @param id
     */
    void customRemoveId(Integer id);
}