package tech.aistar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/11/20/9:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collect implements Serializable {
    private Integer id;
    private Integer phoneId;
    private String name;
    private String url;
    private Float price;
    private String intro;
    private Integer num;
    private Float total;
    private Integer userId;
    private Date createDate;
    private Integer status;
}
