package cn.home.jeffrey.user.service.impl;

import cn.home.jeffrey.user.entity.User;
import cn.home.jeffrey.user.mapper.UserMapper;
import cn.home.jeffrey.user.service.SubUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jeffrey
 * @since 2020-03-25
 */
@Service
public class SubUserServiceImpl extends ServiceImpl<UserMapper, User> implements SubUserService {

}
