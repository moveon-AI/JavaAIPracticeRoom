package cn.zzuli.service;


import cn.zzuli.vo.AiGenerateRequestVo;
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


    String callKimiAi(String prompt) throws InterruptedException;
}