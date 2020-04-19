package cn.home.jeffrey.common.lettuce;

/**
 * 基础缓存父类
 */
public abstract class BaseCacheClient {
    /**
     * 缓存前缀
     */
    protected static final String CACHE_PRE = "nvwa:";

    /**
     * 拼接前缀
     *
     * @return
     */
    protected static final String contantPre(String key) {
        return CACHE_PRE + key;
    }

}
