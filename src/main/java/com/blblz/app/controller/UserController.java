package com.blblz.app.controller;

import com.blblz.app.domain.User;
import com.blblz.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WeiYangDong
 * @date 2018/3/2 17:48
 * @deprecated
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setUserName(name);
        if (userRepository.saveUser(user)){
            System.out.printf("用户对象：%s 保存成功！\n",user);
        }
        return user;
    }
}
