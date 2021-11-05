package tech.aistar.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 本类用来演示: 单元测试
 *
 * @author: Q
 * @date: 2021/10/25 4:20 上午
 */
@SpringBootTest
public class PhoneMapperTest {
    @Autowired
    private PhoneMapper phoneMapper;
    @Test
    public void testFindAll(){
        phoneMapper.findAll().forEach(e-> System.out.println(e));
    }

}