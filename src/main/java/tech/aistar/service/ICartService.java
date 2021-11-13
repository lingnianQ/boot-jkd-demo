package tech.aistar.service;

import tech.aistar.model.Cart;


public interface ICartService {
    int save(Cart cart);

    Cart find(Integer phoneId,Integer userId);

    int update(Integer id);
}
