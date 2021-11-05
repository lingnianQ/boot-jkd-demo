package tech.aistar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 本类用来演示: 用户实体类
 *
 * @author: Q
 * @date: 2021/10/25 5:00 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneType implements Serializable {
    private Integer id;
    private String phoneName;
    private String urls;
    private Float price;
    private String remark;
    private String phoneTypeName;

}
