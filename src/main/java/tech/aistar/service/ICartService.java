package tech.aistar.service;

import tech.aistar.model.Cart;

/**
 * 本类用来演示:
 *
 * @author: success
 * @date: 2021/11/13 9:38 上午
 */
public interface ICartService {
    int save(Cart cart);

    Cart find(Integer phoneId,Integer userId);

    int update(Integer id);
}
