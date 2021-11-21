package tech.aistar.mapper;

import org.apache.ibatis.annotations.*;
import tech.aistar.model.Cart;

import java.util.List;

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

    @Update("update shop_cart set num=num-1,total=num*price where id=#{id}")
    int updateSup(Integer id);

    @Delete("delete from shop_cart where id=#{id}")
    int delById(Integer id);

    @Select("select * from shop_cart where user_id=#{userId} order by create_date desc")
    List<Cart> getAll(@Param("userId") Integer userId);

    void batchDeletes(List delList);
}
