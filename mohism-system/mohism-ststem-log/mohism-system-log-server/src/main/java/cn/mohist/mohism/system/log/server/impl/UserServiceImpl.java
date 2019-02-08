package cn.mohist.mohism.system.log.server.impl;

import cn.mohist.mohism.system.log.model.User;
import cn.mohist.mohism.system.log.server.mapper.UserMapper;
import cn.mohist.mohism.system.log.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUsers() {
       return userMapper.selectAllUsers();
    }
}
