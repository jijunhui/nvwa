package cn.home.jeffrey.common.enums;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/3/26 0:11
 * @description 结果enum
 */
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS("0", "成功"),
    /**
     * 失败
     */
    FAIL("-1", "失败"),
    /**
     * 重复提交的状态
     */
    REPEAT("-2", "重复");

    private String code;
    private String message;

    private ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 根据code返回enum
     *
     * @param code
     * @return
     */
    public static ResultEnum getResultEnum(String code) {
        for (ResultEnum u : ResultEnum.values()) {
            if (code.equals(u.getCode())) {
                return u;
            }
        }
        return null;
    }
}
