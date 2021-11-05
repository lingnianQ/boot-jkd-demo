package tech.aistar.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/10/31/2:51
 */
@SpringBootTest
public class PhoneMapperTypeTest {
    @Autowired
    private PhoneTypeMapper phoneTypeMapper;
    @Test
    public void testFindAll(){ phoneTypeMapper.findAll().forEach(e-> System.out.println(e)); }
}
