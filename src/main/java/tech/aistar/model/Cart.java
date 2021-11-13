package tech.aistar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {

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
