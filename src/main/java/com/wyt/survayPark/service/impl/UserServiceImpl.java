package com.wyt.survayPark.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wyt.survayPark.dao.BaseDao;
import com.wyt.survayPark.domain.User;
import com.wyt.survayPark.service.UserService;
import com.wyt.survayPark.util.ValidateUtil;

@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Resource(name="userDao")
	public void setDao(BaseDao dao) {
		super.setDao(dao);
	}

	public boolean isRegisted(String email) {
		String hql = "from user u where u.email = ?";
		List params = new ArrayList();
		params.add(email);
		List<User> list = this.findEntityByHQL(hql, params);
		if(!ValidateUtil.isValid(list)){
			return false;
		}
		return true;
	}

	public User isValidateLogIn(String email, String password) {
		String hql = "from user u where u.email = ? and u.password =?";
		List params = new ArrayList();
		params.add(email);
		params.add(password);
		List<User> userArray = this.findEntityByHQL(hql, params);
		return ValidateUtil.isValid(userArray)?userArray.get(0):null;
	}
}
