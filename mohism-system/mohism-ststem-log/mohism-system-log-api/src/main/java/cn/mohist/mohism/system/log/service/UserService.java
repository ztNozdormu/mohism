package cn.mohist.mohism.system.log.service;



import cn.mohist.mohism.system.log.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
}
