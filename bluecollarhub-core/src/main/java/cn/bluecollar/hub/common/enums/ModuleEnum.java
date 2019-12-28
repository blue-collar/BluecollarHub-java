package cn.bluecollar.hub.common.enums;

import lombok.Getter;

/**
 * TypeEnum
 *
 * @author rick
 * @date 2019/01/08 20:21
 * @description 模块枚举
 */
@Getter
public enum ModuleEnum {
    /**
     * 文章模块
     */
    ARTICLE(0),
    /**
     * 作品模块
     */
    OPUS(1);

    private int value;

    ModuleEnum(int value) {
        this.value = value;
    }
}
