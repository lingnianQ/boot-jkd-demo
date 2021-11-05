package tech.aistar.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tech.aistar.model.PhoneType;


import java.util.List;

/**
 * 本类用来演示: 用户实体类
 *
 * @author: Q
 * @date: 2021/10/25 5:00 上午
 */
@Mapper
public interface PhoneTypeMapper {
    /**
     * 查询所有的手机种类
     * @return
     */
    @Select("SELECT t_phone.id,t_phone.phoneName,t_phone.urls,t_phone.price,t_phone.remark,phone_type.phoneTypeName FROM t_phone INNER JOIN phone_type ON t_phone.phone_type_id=phone_type.id")
    List<PhoneType> findAll();

    /**
     * 根据id进行查询 - id是主键列 - 能够唯一确定一行[元组] - 唯一
     * 主键列特点 - 非空且唯一的.
     *
     * #{变量}  ->  sql语句中的占位符
     * @param id
     * @return
     */
/*
    @Select("select * from phone_type where id=#{id}")
    PhoneType findById(Integer id);
*/

    /**
    * @param name
    * @return
    */
/*
    @Select("select * from phone_type where name=#{name}")
    PhoneType findByPhoneTypename(String name);
*/

    /**
     * 根据id进行删除
     * @param id
     * @return mysql受影响的行数 - 删除了n行,返回n,如果删除失败,则返回0
     * 根据该方法的返回值是否为0,来判断是否执行删除这个工作是否成功.
     */
/*    @Delete("delete from phone_type where id = #{id}")
    int delById(Integer id)*/;

    /**
     * 更新手机信息
     * #{变量} 一定是你的实体类中的属性的名称
     * @param phoneType
     * @return
     */
/*
    @Update("update phone_type set name=#{name} where id=#{id}")
    int update(PhoneType phoneType);
*/

    /**
    *@Description:
    *@param phoneType
    *@return 
    */
/*    @Insert("insert into phone_type values(null,#{name})")
    int save(PhoneType phoneType);*/
}
