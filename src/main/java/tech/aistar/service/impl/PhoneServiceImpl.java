package tech.aistar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.aistar.mapper.PhoneMapper;
import tech.aistar.model.Phone;
import tech.aistar.service.IPhoneService;

import java.util.List;


/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/10/31/3:22
 */
@Service // 让service层的类交给spring进行管理
public class PhoneServiceImpl implements IPhoneService {
    //service层调用Mapper层
    //mapper层 - 和db进行交互的
    //service层 - 调用mapper层,进行数据的业务逻辑处理

    @Autowired
    private PhoneMapper phoneMapper;

    @Override
    public List<Phone> findAll(){
        return phoneMapper.findAll();
    }
}
