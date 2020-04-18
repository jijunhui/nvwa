package cn.home.jeffrey.user.service.impl;

import cn.home.jeffrey.common.dto.user.UserDto;
import cn.home.jeffrey.common.enums.ErrCodeEnum;
import cn.home.jeffrey.common.exceptions.SubUserServiceException;
import cn.home.jeffrey.user.entity.User;
import cn.home.jeffrey.user.mapper.UserMapper;
import cn.home.jeffrey.user.service.SubUserService;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jeffrey
 * @since 2020-03-25
 */
@Service
@Slf4j
public class SubUserServiceImpl extends ServiceImpl<UserMapper, User> implements SubUserService {

    @Override
    @Transactional
    public UserDto register(UserDto userDto) {
        if (null == userDto) {
            log.warn("用户注册_请求参数不能空");
            throw new SubUserServiceException(ErrCodeEnum.PARAM_ISNULL, "请求参数不能为空");
        }

        if (StrUtil.isEmpty(userDto.getPhone())) {
            log.warn("用户注册_请求参数手机号不能空");
            throw new SubUserServiceException(ErrCodeEnum.USER_PHONE_NULL, "手机号不能为空");
        }

        if (StrUtil.isEmpty(userDto.getPwd())) {
            log.warn("用户注册_请求参数密码不能空");
            throw new SubUserServiceException(ErrCodeEnum.USER_PASSWORD_NULL, "密码不能为空");
        }
        UserDto result = new UserDto();
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(user.getCreateTime());
        user.setRegisterTime(user.getCreateTime());
        user.setStatus(0);
        this.save(user);
        BeanUtils.copyProperties(user, result);
        log.info("用户注册成功:{}", user);
        return result;
    }
}
