package cn.netbuffer.dubbo.dao;

import cn.netbuffer.dubbo.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserDao extends PagingAndSortingRepository<User,Long>,JpaSpecificationExecutor<User>{
}