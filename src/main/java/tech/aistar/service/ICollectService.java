package tech.aistar.service;

import tech.aistar.model.Cart;
import tech.aistar.model.Collect;

import java.util.List;

/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/11/20/9:52
 */
public interface ICollectService {
    int save(Collect collect);

    Collect find(Integer phoneId, Integer userId);

    List<Collect> loadAll(Integer currentPage,Integer userId);

    int update(Integer id);

    int deleteById(Integer id);

    void batchDeletes(List delList);
}
