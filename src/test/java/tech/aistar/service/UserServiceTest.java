package tech.aistar.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 本类用来演示:
 *
 * @author: success
 * @date: 2021/10/30 2:50 下午
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void testLogin(){
        System.out.println(userService.login("admin"));
    }
}
