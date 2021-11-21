package tech.aistar.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.aistar.mapper.CartMapper;
import tech.aistar.model.Cart;
import tech.aistar.service.ICartService;

import java.util.List;


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

    @Override
    public int updateSup(Integer id) {
        return cartMapper.updateSup(id);
    }

    @Override
    public List<Cart> loadAll(Integer currentPage,Integer userId) {
        PageHelper.startPage(currentPage,5);
        return cartMapper.getAll(userId);
    }

    @Override
    public int delById(Integer id) {
        return cartMapper.delById(id);
    }

    /**
     * 批量删除
     * @param delList
     */
    @Override
    public void batchDeletes(List delList) {
        cartMapper.batchDeletes(delList);
    }

}
