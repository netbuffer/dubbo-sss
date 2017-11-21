package cn.netbuffer.dubbo.serviceimpl;

import cn.netbuffer.dubbo.service.IUserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService{

    public String getUser(Long id) {
        return "user";
    }
}