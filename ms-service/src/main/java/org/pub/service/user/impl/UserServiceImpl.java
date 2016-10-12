package org.pub.service.user.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.pub.common.Page;
import org.pub.dal.user.db.IUserDao;
import org.pub.dal.user.model.Users;
import org.pub.dal.user.model.VuserMenu;
import org.pub.service.user.IUserService;
import org.pub.service.user.model.UserDTO;
import org.pub.service.user.model.UserMenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	
	/*
	 * 登录验证
	 * @see com.cxstock.biz.power.UserBiz#login(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public UserDTO login(String code, String pass) {
		UserDTO dto =null;
		Users user= new Users();
		user.setLogincode(code);
		user.setPassword(pass);
		try {
			user = (Users)userDao.login(user);
			if(user!=null){
				dto = UserDTO.createDto(user);
				List<VuserMenu> list = userDao.queryMenuList(user);
				JSONArray jsong = JSONArray.fromObject(new UserMenuDTO().getTree("0",list));
				dto.setUsermenu(jsong.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	
	@Override
	public String getMenuList(String userId) {
		Users user= new Users();
		user.setUserid(userId);
		try {
			List<VuserMenu>	list = userDao.queryMenuList(user);
			JSONArray jsong = JSONArray.fromObject(new UserMenuDTO().getTree("0",list));
			return jsong.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 分页查询用户列表
	 * @see com.cxstock.biz.power.UserBiz#findPageUser(com.cxstock.utils.system.Page)
	 */
	@SuppressWarnings("unchecked")
	public void findPageUser(Page page) {
		
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("start", page.getStart());
		condition.put("limit", page.getLimit());
		try {
			List<Users>	userList =userDao.queryList(condition);
			List dtoList = UserDTO.createDtos(userList);
			int totalCount = userDao.queryCount(condition);
			page.setRoot(dtoList);
			page.setTotal(totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 保存/修改用户
	 * @see com.cxstock.biz.power.UserBiz#saveOrUpdateUser(com.cxstock.biz.power.dto.UserDTO)
	 */
	public boolean saveOrUpdateUser(UserDTO dto) {
//		Users user = new Users();
//		if(dto.getUserid()!=null){
//			user = (Users)userDao.loadById(Users.class, dto.getUserid());
//		}else{
//			Users u = (Users)userDao.loadObject("from Users where logincode='"+dto.getLogincode()+"'");
//			if(u!=null){
//				return false;
//			}
//			user.setLogincode(dto.getLogincode());
//			user.setState(0);
//		}
//		user.setPassword(dto.getPassword());
//		user.setUsername(dto.getUsername());
//		user.setRole(new Role(dto.getRoleid()));
//		user.setBz(dto.getBz());
//		userDao.saveOrUpdate(user);
		return true;
	}
	
	/*
	 * 删除用户
	 * @see com.cxstock.biz.power.UserBiz#deleteUser(java.lang.String)
	 */
	public void deleteUser(String userid) {
//		userDao.deleteById(Users.class, userid);	
	}


	

}
