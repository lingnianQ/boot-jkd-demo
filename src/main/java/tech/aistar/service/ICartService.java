package tech.aistar.service;

import tech.aistar.model.Cart;

import java.util.List;


public interface ICartService {
    int save(Cart cart);

    Cart find(Integer phoneId,Integer userId);

    int update(Integer id);

    int updateSup(Integer id);

    List<Cart> loadAll(Integer currentPage,Integer userId);

    int delById(Integer id);

    void batchDeletes(List delList);

}
