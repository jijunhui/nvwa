package cn.home.jeffrey.common.enums;

/**
 * @Author jeffrey
 * @Date 2020/03/25 16:57
 * @Version 1.0.0
 * @Description 错误码
 */
public enum ErrCodeEnum {

    ERR_SYSTEM_SERVICE("999999", "系统服务异常"),
    ERR_SUB_USER_SERVICE("999991", "用户子服务异常"),
    /**
     * 参数不完整
     */
    PARAM_INVALID("100001", "参数不合法"),

    PARAM_ISNULL("100002", "参数不能为空"),

    /**
     * 主键ID不能为空
     */
    ID_NULL("100003", "主键ID不能为空"),

    /**
     * 重复提交的状态
     */
    COMMON_REPEAT("100009", "重复"),

    /**
     * 请输入手机号码
     */
    USER_PHONE_NULL("100101", "请输入手机号码"),
    /**
     * 手机号不能为null
     */
    USER_PHONE_FORMAT("100102", "手机号码格式不正确"),

    /**
     * 密码格式不正确
     */
    USER_PASSWORD_FORMAT("100201", "密码格式不正确"),
    /**
     * 密码不能为null
     */
    USER_PASSWORD_NULL("100202", "密码不能为空"),
    ;

    private String code;
    private String desc;

    private ErrCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public ErrCodeEnum setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    /**
     * 根据code返回 ErrCodeBusinessEnum
     *
     * @param code
     * @return
     */
    public static ErrCodeEnum getErrCodeEnum(String code) {
        for (ErrCodeEnum errCodeEnum : ErrCodeEnum.values()) {
            if (errCodeEnum.getCode().equals(code)) {
                return errCodeEnum;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return String.format("[%s]%s", this.code, this.desc);
    }
}
