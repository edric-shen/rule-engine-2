package cn.ruleengine.web.vo.common;

import cn.ruleengine.core.value.VariableType;
import cn.ruleengine.web.vo.condition.ConfigValue;
import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 丁乾文
 * @create 2021/1/23
 * @since 1.0.0
 */
@Data
public class ReferenceData {

    private Set<Integer> elementIds = new HashSet<>();
    private Set<Integer> variableIds = new HashSet<>();
    private Set<Integer> conditionIds = new HashSet<>();

    public void addConditionId(Integer id) {
        this.conditionIds.add(id);
    }

    public void addVariableId(Integer id) {
        this.variableIds.add(id);
    }

    public void addElementId(Integer id) {
        this.elementIds.add(id);
    }

    public void resolve(ConfigValue configValue) {
        if (configValue == null) {
            return;
        }
        Integer type = configValue.getType();
        if (type == null) {
            return;
        }
        String value = configValue.getValue();
        if (value == null) {
            return;
        }
        if (VariableType.ELEMENT.getType().equals(type)) {
            this.addElementId(Integer.valueOf(value));
        } else if (VariableType.VARIABLE.getType().equals(type)) {
            this.addVariableId(Integer.valueOf(value));
        }
    }

    /**
     * 转为json
     *
     * @return json
     */
    public String toJson() {
        return JSON.toJSONString(this);
    }

}
