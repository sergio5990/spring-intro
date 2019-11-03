package com.github.sergio5990.spring.intro.beans;

import com.github.sergio5990.spring.intro.model.User;

public interface UserRepository {
    User findByUserName(String userName);
}
