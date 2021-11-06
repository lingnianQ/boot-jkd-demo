package tech.aistar.mapper;

import org.apache.ibatis.annotations.*;
import tech.aistar.model.Phone;


import java.util.List;

/**
 * 本类用来演示: 持久层接口
 *
 * @author: Q
 * @date: 2021/10/25 4:05 上午
 */
@Mapper
public interface PhoneMapper {
    /**
     * 查询所有的手机种类
     * @return
     */
    @Select("select * from t_phone")
    List<Phone> findAll();

    List<Phone> getAll(String name);

    /**
     * 根据id进行查询 - id是主键列 - 能够唯一确定一行[元组] - 唯一
     * 主键列特点 - 非空且唯一的.
     *
     * #{变量}  ->  sql语句中的占位符
     * @param id
     * @return
     */

    @Select("select * from t_phone where id=#{id}")
    Phone findById(Integer id);

    /**
     * 根据用户名进行插叙 - 用户名在注册(插入)必须要唯一性
     *
     * @param name
     * @return
     */
    @Select("select * from t_phone where phoneName=#{phoneName}")
    Phone findByPhoneName(String name);

    /**
     * 根据id进行删除
     * @param id
     * @return mysql受影响的行数 - 删除了n行,返回n,如果删除失败,则返回0
     * 根据该方法的返回值是否为0,来判断是否执行删除这个工作是否成功.
     */
    @Delete("delete from t_phone where id = #{id}")
    int delById(Integer id);

    /**
     * 更新用户信息
     * #{变量} 一定是你的实体类中的属性的名称
     * @param phone
     * @return
     */
    @Update("update t_phone set phoneName=#{phoneName},urls=#{urls},price=#{price},remark=#{remark},phone_type_id=#{phone_type_id} where id=#{id}")
    int update(Phone phone);

    /**
     * 插入用户信息
     * @param phone
     * @return
     */
    @Insert("insert into t_phone values(null,#{phoneName},#{urls},#{price},#{remark},#{phone_type_id})")
    int save(Phone phone);
}
