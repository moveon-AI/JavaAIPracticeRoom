package cn.zzuli.service;


import cn.zzuli.entity.Question;
import cn.zzuli.vo.AiGenerateRequestVo;
import cn.zzuli.vo.GradingResult;
import cn.zzuli.vo.QuestionImportVo;

import java.util.List;

/**
 * Kimi AI服务接口
 * 用于调用Kimi API生成题目
 */
public interface KimiAiService {


    /**
     * ai题目信息生成
     * @param request
     * @return
     */
    List<QuestionImportVo> aiGenerateQuestions(AiGenerateRequestVo request) throws InterruptedException;

    /**
     * 调用Kimi AI(封装Kimi模型的方法）
     * @param prompt
     * @return
     */
    String callKimiAi(String prompt) throws InterruptedException;

    /**
     * 构建评分提示(判卷）
     * @param question
     * @param userAnswer
     * @param maxScore
     * @return
     */
    String buildGradingPrompt(Question question, String userAnswer, Integer maxScore);

    /**
     * 构建考试总评提示词
     */
    String buildSummaryPrompt(Integer totalScore, Integer maxScore, Integer questionCount, Integer correctCount);

    /**
     * 使用ai,进行简答题判断
     * @param question
     * @param userAnswer
     * @param maxScore
     * @return
     */
    GradingResult gradingTextQuestion(Question question, String userAnswer, Integer maxScore) throws InterruptedException;

    /**
     * 生成ai评语
     * @param totalScore
     * @param maxScore
     * @param questionCount
     * @param correctCount
     * @return
     */
    String buildSummary(Integer totalScore, Integer maxScore, Integer questionCount, Integer correctCount) throws InterruptedException;

}