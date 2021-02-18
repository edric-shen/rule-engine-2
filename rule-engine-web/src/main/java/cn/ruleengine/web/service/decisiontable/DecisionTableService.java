package cn.ruleengine.web.service.decisiontable;

import cn.ruleengine.common.vo.*;
import cn.ruleengine.web.vo.common.ViewRequest;
import cn.ruleengine.web.vo.decisiontable.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 丁乾文
 * @create 2020/12/27
 * @since 1.0.0
 */
public interface DecisionTableService {

    /**
     * 决策表列表
     *
     * @param pageRequest 分页查询参数
     * @return page
     */
    PageResult<ListDecisionTableResponse> list(PageRequest<ListDecisionTableRequest> pageRequest);

    /**
     * 保存或者更新决策表定义信息
     *
     * @param decisionTableDefinition 定义信息
     * @return 决策表id
     */
    Integer saveOrUpdateDecisionTableDefinition(DecisionTableDefinition decisionTableDefinition);

    /**
     * 决策表code是否存在
     *
     * @param code 规则code
     * @return true存在
     */
    Boolean decisionTableCodeIsExists(String code);

    /**
     * 查询决策表定义信息
     *
     * @param id 决策表id
     * @return DecisionTableDefinition
     */
    DecisionTableDefinition getDecisionTableDefinition(Integer id);

    /**
     * 删除决策表
     *
     * @param id 决策表id
     * @return true
     */
    Boolean delete(Integer id);

    /**
     * 更新决策表信息
     *
     * @param updateDecisionTableRequest 决策表配置数据
     * @return true执行成功
     */
    Boolean updateDecisionTable(UpdateDecisionTableRequest updateDecisionTableRequest);

    /**
     * 获取决策表信息
     *
     * @param id 决策表id
     * @return 决策表信息
     */
    GetDecisionTableResponse getDecisionTableConfig(Integer id);

    /**
     * 生成决策表代发布
     *
     * @param releaseRequest 配置数据
     * @return true
     */
    Boolean generationRelease(GenerationReleaseRequest releaseRequest);

    /**
     * 获取决策表展示信息
     *
     * @param viewRequest 决策表id
     * @return ViewDecisionTableResponse
     */
    ViewDecisionTableResponse view(ViewRequest viewRequest);

    /**
     * 规则决策表
     *
     * @param id 决策表id
     * @return true
     */
    Boolean publish(Integer id);

}
