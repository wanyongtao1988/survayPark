package com.wyt.survayPark.action;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.wyt.survayPark.domain.User;
import com.wyt.survayPark.service.UserService;
import com.wyt.survayPark.util.DataUtil;
import com.wyt.survayPark.util.ValidateUtil;

@Controller("regAction")
@Scope("prototype")
public class RegAction extends BaseAction<User> {

	private static final long serialVersionUID = 1L;
	
	private String confirmPassword;
	
	
	@Resource(name="userService")
	private UserService userService;
	@SkipValidation
	public String toRegPage(){
		return "regPage";
	}
	
	public String doReg(){
		model.setPassword(DataUtil.md5(model.getPassword()));
		userService.saveEntity(model);
		return SUCCESS;
	}
	
	public void validate(){
		//1.非空
		if(!ValidateUtil.isValid(model.getEmail())){
			addFieldError("email", "email是必填项!");
		}
		if(!ValidateUtil.isValid(model.getPassword())){
			addFieldError("password", "密码是必填项!");
		}
		if(!ValidateUtil.isValid(model.getNickName())){
			addFieldError("nickName", "昵称是必填项!");
		}
		if(this.hasErrors()){
			return;
		}
		//2.密码一致性
		if(!model.getPassword().equals(confirmPassword)){
			addFieldError("password", "密码输入不一致!");
			return ;
		}
		//3.email是否被占用
		if(userService.isRegisted(model.getEmail())){
			addFieldError("email", "邮箱已占用!");
		}
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
