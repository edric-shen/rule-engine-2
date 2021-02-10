package cn.ruleengine.core.rule.strategy;


import cn.ruleengine.core.Input;
import cn.ruleengine.core.RuleEngineConfiguration;
import cn.ruleengine.core.rule.Rule;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 丁乾文
 * @create 2020/12/29
 * @since 1.0.0
 */
@Slf4j
public class AllRuleStrategy implements RuleSetStrategy {

    private static final AllRuleStrategy ALL_RULE_STRATEGY = new AllRuleStrategy();

    private AllRuleStrategy() {
    }

    public static AllRuleStrategy getInstance() {
        return ALL_RULE_STRATEGY;
    }

    @Override
    public List<Object> compute(List<Rule> rules, Input input, RuleEngineConfiguration configuration) {
        List<Object> actions = new ArrayList<>();
        for (Rule rule : rules) {
            log.debug("执行规则：" + rule.getName());
            Object action = rule.execute(input, configuration);
            if (action != null) {
                if (log.isDebugEnabled()) {
                    log.debug("规则：{} 命中结果：{}", rule.getName(), action);
                }
                actions.add(action);
            }
        }
        return actions;
    }
}
