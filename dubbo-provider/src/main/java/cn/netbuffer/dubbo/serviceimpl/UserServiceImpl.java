package cn.netbuffer.dubbo.serviceimpl;

import cn.netbuffer.dubbo.dao.IUserDao;
import cn.netbuffer.dubbo.entity.User;
import cn.netbuffer.dubbo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService{

    @Resource
    private IUserDao userDao;

    public User getUser(Long id) {
        return userDao.findOne(id);
    }
}