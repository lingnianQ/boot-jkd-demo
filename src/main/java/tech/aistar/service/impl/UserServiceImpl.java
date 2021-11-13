package tech.aistar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.aistar.mapper.UserMapper;
import tech.aistar.model.User;
import tech.aistar.service.IUserService;

/**
 * 本类用来演示:
 *
 * @author: Q
 * @date: 2021/10/30 2:48 下午
 */
@Service // 让service层的类交给spring进行管理
public class UserServiceImpl implements IUserService {

    //service层调用Mapper层
    //mapper层 - 和db进行交互的
    //service层 - 调用mapper层,进行数据的业务逻辑处理

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username) {
        return userMapper.findByUsername(username);
    }
}
