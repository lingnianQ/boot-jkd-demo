package tech.aistar.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/10/30/11:29
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        userMapper.findAll().forEach(e-> System.out.println(e));
    }
}
