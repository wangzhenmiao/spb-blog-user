package com.wangzhen.spbbloguser.service;

import com.wangzhen.spbbloguser.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    /**
     * 新增、编辑、保存用户
     */
    User saveOrUpdateUser(User user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    User registerUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void removeUser(Long id);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    Optional<User> getById(Long id);

    /**
     * 根据用户名进行模糊分页查找
     * @param name
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);

}