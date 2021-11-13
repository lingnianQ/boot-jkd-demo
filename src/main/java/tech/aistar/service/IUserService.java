package tech.aistar.service;


import tech.aistar.model.User;

/**
 * 本类用来演示: 用户的业务逻辑层
 *
 * @author: Q
 * @date: 2021/10/30 2:47 下午
 */

public interface IUserService {

    /**
     * 根据用户名查找用户
     * @param username 一定是唯一的
     * @return 单个user对象
     */
    User login(String username);
}
