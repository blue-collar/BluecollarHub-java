package cn.bluecollar.hub.common.constants;

/**
 * RedisCacheNames
 *
 * @author rick
 * @date 2019/07/20 18:09
 * @description
 */
public class RedisCacheNames {

    public final static String PROFIX = "BCHUB:";

    /**
     * 文章缓存空间名称
     */
    public final static String ARTICLE = PROFIX + "ARTICLE";

    /**
     * 友情链接列表
     */
    public final static String LINK = PROFIX + "LINK";

    /**
     * 推荐列表
     */
    public final static String RECOMMEND = PROFIX + "RECOMMEND";

    /**
     * 标签列表
     */
    public final static String TAG = PROFIX + "TAG";

    /**
     * 分类列表
     */
    public final static String CATEGORY = PROFIX + "CATEGORY";

    /**
     * 时光轴
     */
    public static final String TIMELINE = PROFIX + "TIMELINE";

}
