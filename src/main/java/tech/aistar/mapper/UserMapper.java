package tech.aistar.mapper;

import org.apache.ibatis.annotations.*;
import tech.aistar.model.User;

import java.util.List;

/**
 * 本类用来演示:
 *
 * @author: Q
 * @date: 2021/10/30 11:27 上午
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有的用户
     * @return
     */
    @Select("select * from t_user")
    List<User> findAll();

    /**
     * 根据id进行查询 - id是主键列 - 能够唯一确定一行[元组] - 唯一
     * 主键列特点 - 非空且唯一的.
     *
     * #{变量}  ->  sql语句中的占位符
     * @param id
     * @return
     */
    @Select("select * from t_user where id=#{id}")
    User findById(Integer id);

    /**
     * 根据用户名进行插叙 - 用户名在注册(插入)必须要唯一性
     *
     * @param username
     * @return
     */
    @Select("select * from t_user where username=#{username}")
    User findByUsername(String username);

    /**
     * 根据id进行删除
     * @param id
     * @return mysql受影响的行数 - 删除了n行,返回n,如果删除失败,则返回0
     * 根据该方法的返回值是否为0,来判断是否执行删除这个工作是否成功.
     */
    @Delete("delete from t_user where id = #{id}")
    int delById(Integer id);

    /**
     * 更新用户信息
     * #{变量} 一定是你的实体类中的属性的名称
     * @param user
     * @return
     */
    @Update("update t_user set username=#{username},password=#{password},birthday=#{birthday} where id=#{id}")
    int update(User user);

    /**
     * 插入用户信息
     * @param user
     * @return
     */
    @Insert("insert into t_user values(null,#{username},#{password},#{birthday},#{status})")
    int save(User user);
}
