package tech.aistar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/10/30/10:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private String code;

    private String msg;


    private Object data;
}
