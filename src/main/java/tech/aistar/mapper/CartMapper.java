package tech.aistar.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tech.aistar.model.Cart;

/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/11/13/11:03
 */
public interface CartMapper {
    @Insert("insert into shop_cart values(null,#{phoneId},#{name},#{url},#{price},#{intro},#{num},#{total},#{userId},#{createDate},#{status})")
    int insert(Cart cart);

    @Select("select * from shop_cart where phone_id=#{phoneId} and user_id=#{userId}")
    Cart find(@Param("phoneId") Integer phoneId, @Param("userId") Integer userId);

    @Update("update shop_cart set num=num+1,total=num*price where id=#{id}")
    int update(Integer id);
}
