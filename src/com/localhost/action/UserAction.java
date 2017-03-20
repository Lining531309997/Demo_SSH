package com.localhost.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.localhost.service.UserService;
import com.localhost.vo.User;
import com.localhost.vo.Userdetail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private Userdetail userdetail;
	
	@Resource
	private UserService userService;
	
	// 用户登录密码
	private String password;
	
	// 用户的旧密码
	private String pwd1;
	
	/**
	 * 添加新用户
	 * @return
	 * @throws Exception
	 */
	public String addUser() throws Exception {
		System.out.println(user.toString());
		System.out.println(userdetail.toString());
		User registerUser = new User();
		Userdetail registerUserDetail = new Userdetail();
		registerUser.setUsername(user.getUsername());
		registerUser.setPassword(user.getPassword());
		registerUser.setRole(user.getRole());
		registerUserDetail.setAddress(userdetail.getAddress());
		registerUserDetail.setCsrq(userdetail.getCsrq());
		registerUserDetail.setXb(userdetail.getXb());
		registerUserDetail.setEmail(userdetail.getEmail());
		registerUserDetail.setPhone(userdetail.getPhone());
		registerUserDetail.setAddress(userdetail.getAddress());
		registerUserDetail.setTruename(userdetail.getTruename());
		registerUserDetail.setUser(registerUser);
		registerUser.setUserdetail(registerUserDetail);
		
		if(userService.addOrUpdateUser(registerUser)){
			return SUCCESS;	
		} else {		
			return ERROR;
		}
	}
	
	/**
	 * 检查登陆的用户信息
	 * @return
	 * @throws Exception
	 */
	public String checkUser() throws Exception {
		
		Map<String, Object> session = (Map<String, Object>)ActionContext.getContext().getSession();
		User loginUser = userService.checkUser(user);
		if(loginUser != null) {
			session.put("user", loginUser);
			return SUCCESS;	
		} else {
			session.put("role", user.getRole());
			return ERROR;
		}
	}
	
	/**
	 * 退出登录
	 * @return
	 * @throws Exception
	 */
	public String logOut() throws Exception {
		Map<String, Object> session = (Map<String, Object>)ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;		
	}
	
	/**
	 * 修改密码
	 * @return
	 * @throws Exception
	 */
	public String updateUserPassword() throws Exception {
		
		Map<String, Object> session=(Map<String, Object>) ActionContext.getContext().getSession();
		User user1 = (User)session.get("user");
		if(user1.getPassword().equals(pwd1)) {
			Userdetail userDetail1 = user1.getUserdetail();
			user1.setPassword(password);
			userService.addOrUpdateUser(user1);
			session.remove("user");
			return SUCCESS;		
		} else {
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("msg","密码修改失败！");
			return ERROR;
		}
	}
	
	/**
	 * 修改用户信息
	 * @return
	 * @throws Exception
	 */
	public String updateUserDetail() throws Exception {
		
		Map<String, Object> session=(Map<String, Object>)ActionContext.getContext().getSession();
		User user1 = (User) session.get("user");
		user1.getUserdetail().setAddress(userdetail.getAddress());
		user1.getUserdetail().setXb(userdetail.getXb());
		user1.getUserdetail().setCsrq(userdetail.getCsrq());
		user1.getUserdetail().setEmail(userdetail.getEmail());
		user1.getUserdetail().setPhone(userdetail.getPhone());
		user1.getUserdetail().setTruename(userdetail.getTruename());
		
		if(userService.addOrUpdateUser(user1)) {
			session.put("user",user1);
			return SUCCESS;	
		} else {		
			return ERROR;
		}
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the userdetail
	 */
	public Userdetail getUserdetail() {
		return userdetail;
	}

	/**
	 * @param userdetail the userdetail to set
	 */
	public void setUserdetail(Userdetail userdetail) {
		this.userdetail = userdetail;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPwd1() {
		return pwd1;
	}
	
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
}
