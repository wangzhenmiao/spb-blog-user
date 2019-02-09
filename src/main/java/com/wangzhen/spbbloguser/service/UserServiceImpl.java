package com.wangzhen.spbbloguser.service;

import com.wangzhen.spbbloguser.domain.User;
import com.wangzhen.spbbloguser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @ClassName 用户服务接口实现
 * @Description
 * @Author wangzhen
 * @Date 2018/11/17 下午2:14
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> listUsersByNameLike(String name, Pageable pageable) {

        // 模糊查询
        name = "%" + name + "%";
        Page<User> users = userRepository.findByNameLike(name, pageable);
        return users;
    }
}
