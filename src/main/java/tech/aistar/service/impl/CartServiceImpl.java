package tech.aistar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.aistar.mapper.CartMapper;
import tech.aistar.model.Cart;
import tech.aistar.service.ICartService;


@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public int save(Cart cart) {
        return cartMapper.insert(cart);
    }

    @Override
    public Cart find(Integer phoneId, Integer userId) {
        return cartMapper.find(phoneId,userId);
    }

    @Override
    public int update(Integer id) {
        return cartMapper.update(id);
    }
}
