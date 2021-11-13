package tech.aistar.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.aistar.model.Cart;

import java.util.Date;

/**
 * 本类用来演示:
 *
 * @author: success
 * @date: 2021/11/13 9:34 上午
 */
@SpringBootTest
public class CartMapperTest {
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void testInsert(){
        Cart c = new Cart();
        c.setName("小米");
        c.setUrl("xxx.png");
        c.setIntro("假冒");
        c.setPhoneId(4);
        c.setNum(1);
        c.setPrice(10000.0F);
        c.setTotal(10000.0F);
        c.setUserId(1);
        c.setCreateDate(new Date());
        c.setStatus(1);

        cartMapper.insert(c);
    }
}
