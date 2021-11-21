package tech.aistar.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.aistar.mapper.CollectMapper;
import tech.aistar.model.Collect;
import tech.aistar.service.ICollectService;

import java.util.List;

/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/11/20/9:53
 */
@Service
public class CollectServiceImpl implements ICollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public int save(Collect collect) {
        return collectMapper.insert(collect);
    }

    @Override
    public Collect find(Integer phoneId, Integer userId) {
        return collectMapper.find(phoneId, userId);
    }

    @Override
    public List<Collect> loadAll(Integer currentPage,Integer userId) {
        PageHelper.startPage(currentPage,5);
        return collectMapper.getAll(userId);
    }

    @Override
    public int update(Integer id) {
        return collectMapper.update(id);
    }

    @Override
    public int deleteById(Integer id) {
        return collectMapper.deleteById(id);
    }

    @Override
    public void batchDeletes(List delList) {
        collectMapper.batchDeletes(delList);
    }
}
