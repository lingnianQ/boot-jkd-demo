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
 * @date 2021/10/30/11:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private Date birthday;
    private Integer status;
}