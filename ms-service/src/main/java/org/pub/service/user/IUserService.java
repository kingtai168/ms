package org.pub.service.user;

import org.pub.common.Page;
import org.pub.service.user.model.UserDTO;

public interface IUserService {

	/**
	 * 登录验证
	 */
	public UserDTO login(String code, String pass);
	
	
	public String getMenuList(String userId);
	
	/**
	 * 分页查询用户列表
	 */
	public void findPageUser(Page page);
	
	/**
	 * 保存/修改用户
	 */
	public boolean saveOrUpdateUser(UserDTO dto);
	
	/**
	 * 删除用户
	 */
	public void deleteUser(String userid);

}
