package tech.aistar.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.aistar.model.Phone;

import java.util.List;

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
    public void testGetAll(){
        List<Phone> list= phoneMapper.getAll("红");
        if(null!=list){
            for (Phone phone : list) {
                System.out.println(phone);
            }
        }
    }
}