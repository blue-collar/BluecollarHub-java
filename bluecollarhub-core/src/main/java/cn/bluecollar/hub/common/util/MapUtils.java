package cn.bluecollar.hub.common.util;

import java.util.HashMap;

/**
 * MapUtils
 *
 * @author rick
 * @date 2019/10/22 19:38
 * @description Map工具类
 */
public class MapUtils extends HashMap<String, Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
