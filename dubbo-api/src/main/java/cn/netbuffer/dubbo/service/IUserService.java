package cn.netbuffer.dubbo.service;

import cn.netbuffer.dubbo.entity.User;

public interface IUserService {

    User getUser(Long id);
}