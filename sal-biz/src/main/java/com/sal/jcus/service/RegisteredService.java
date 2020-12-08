package com.sal.jcus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sal.jcus.entity.User;

/**
 * 注册页面表
 */
public interface RegisteredService extends IService<User> {
    User getNOToUser(String phone);
}
