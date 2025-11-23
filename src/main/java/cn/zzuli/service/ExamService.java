package cn.zzuli.service;

import cn.zzuli.entity.ExamRecord;
import cn.zzuli.vo.ExamRankingVO;
import cn.zzuli.vo.StartExamVo;
import cn.zzuli.vo.SubmitAnswerVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 考试服务接口
 */
public interface ExamService extends IService<ExamRecord> {

    /**
     * 开始考试
     * @param startExamVo
     * @return
     */
    ExamRecord startExam(StartExamVo startExamVo);

    /**
     * 根据id获取考试记录
     * @param id
     * @return
     */
    ExamRecord customGetExamRecordById(Integer id);

    /**
     * 提交考试答案
     * @param examRecordId
     * @param answers
     */
    void customSubmitAnswer(Integer examRecordId, List<SubmitAnswerVo> answers) throws InterruptedException;

    /**
     * AI智能判卷
     * @param examRecordId
     * @return
     */
    ExamRecord gradeExam(Integer examRecordId) throws InterruptedException;

    /**
     * 删除考试记录
     * @param id
     */
    void customRemoveById(Integer id);

    /**
     * 获取考试排名
     * @param paperId
     * @param limit
     * @return
     */
    List<ExamRankingVO> customGetRanking(Integer paperId, Integer limit);
}
 