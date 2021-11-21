package tech.aistar.mapper;

import org.apache.ibatis.annotations.*;
import tech.aistar.model.Cart;
import tech.aistar.model.Collect;

import java.util.List;

/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/11/20/9:38
 */
public interface CollectMapper {
    @Insert("insert into my_collect values(null,#{phoneId},#{name},#{url},#{price},#{intro},#{num},#{total},#{userId},#{createDate},#{status})")
    int insert(Collect collect);

    @Select("select * from my_collect where phone_id=#{phoneId} and user_id=#{userId}")
    Collect find(@Param("phoneId") Integer phoneId, @Param("userId") Integer userId);

    @Select("select * from my_collect where user_id=#{userId}")
    List<Collect> getAll(@Param("userId") Integer userId);
    @Update("update my_collect set num=num+1,total=num*price where id=#{id}")
    int update(Integer id);

    @Delete("delete from my_collect where id=#{id}")
    int deleteById(Integer id);

    void batchDeletes(List delList);
}
