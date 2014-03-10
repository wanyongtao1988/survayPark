package com.wyt.survayPark.service;

import com.wyt.survayPark.domain.User;

public interface UserService extends BaseService<User> {

	public boolean isRegisted(String email);

	public User isValidateLogIn(String email, String password);

}
