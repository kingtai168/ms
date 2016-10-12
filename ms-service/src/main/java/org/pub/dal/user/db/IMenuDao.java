package org.pub.dal.user.db;

import java.util.List;

import org.pub.dal.user.model.Menu;
import org.pub.dal.user.model.RoleMenu_temp;

/**
 * 菜单Dao接口
 * @author admin
 *
 */
public interface IMenuDao {
	
	/**
	 * 查询所有菜单
	 * @return
	 * @throws Exception
	 */
	public List<Menu> queryMenuList();
	
	/**
	 * 根据权限ID查询所有菜单
	 * @param roleid
	 * @return
	 * @throws Exception
	 */
	public List<RoleMenu_temp> queryRoleMenuList(String roleid);

}
