package tech.aistar.service;

import tech.aistar.model.Phone;

import java.io.Serializable;
import java.util.List;

/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/10/31/3:21
 */

public interface IPhoneService extends Serializable {
    List<Phone> findAll(String name,Integer currentPage);
    List<Phone> loadAll(String name,Integer currentPage);
    Phone getById(Integer id);
    int addCount(Integer id);
    int supCount(Integer id);
}
