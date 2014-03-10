package com.wyt.survayPark.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.wyt.survayPark.domain.User;
import com.wyt.survayPark.service.UserService;
import com.wyt.survayPark.util.DataUtil;

@Controller("logInAction")
@Scope("prototype")
public class LogInAction extends BaseAction<User> implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	@Resource(name="userService")
	private UserService userService;
	
	private Map<String,Object> sessionMap;
	
	//到达登陆页面
	public String toLogInPage(){
		return "logInPage";
	}
	//登陆页面
	public String doLogIn(){
		return SUCCESS;
	}
	//该方法的检验
	public void validateDoLogIn(){
		User user = userService.isValidateLogIn(model.getEmail(),DataUtil.md5(model.getPassword()));
		if(user == null){
			addActionError("email/password 错误");
		}else{
			sessionMap.put("user", user);
		}
		
	}
	
	public void setSession(Map<String, Object> map) {
		this.sessionMap=map;
		
	}
	
	

}
