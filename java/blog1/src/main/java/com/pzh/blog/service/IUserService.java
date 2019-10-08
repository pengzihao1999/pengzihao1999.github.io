package com.pzh.blog.service;

import com.pzh.blog.domain.User;

public interface IUserService {
     User checkUser(String username, String password);
}
