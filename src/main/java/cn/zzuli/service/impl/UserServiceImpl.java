package cn.zzuli.service.impl;

import cn.zzuli.entity.User;
import cn.zzuli.mapper.UserMapper;
import cn.zzuli.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
 * 用户Service实现类
 * 实现用户相关的业务逻辑
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

} 