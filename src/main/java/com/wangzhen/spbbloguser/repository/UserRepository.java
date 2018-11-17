package com.wangzhen.spbbloguser.repository;

import com.wangzhen.spbbloguser.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

/**
 * @ClassName UserRepository
 * @Description
 * @Author wangzhen
 * @Date 2018/11/10 下午4:27
 **/
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 根据用户姓名分页查询用户列表
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findByNameLike(String name, Pageable pageable);

    /**
     * 根据用户账号查询用户
     * @param name
     * @return
     */
    User findByUsername(String name);
}
