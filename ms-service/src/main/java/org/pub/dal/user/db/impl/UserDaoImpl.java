package org.pub.dal.user.db.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.mx.dbaccess.orm.mybatis.impl.BaseDaoImpl;
import org.pub.dal.user.db.IUserDao;
import org.pub.dal.user.model.Users;
import org.pub.dal.user.model.VuserMenu;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl extends BaseDaoImpl<Users> implements IUserDao {

	@Override
	public Users login(Users user) throws SQLException {
		return sqlSessionTemplate.selectOne("User.login", user);
	}

	@Override
	public List<VuserMenu> queryMenuList(Users user) throws SQLException {
		return sqlSessionTemplate.selectList("User.queryMenuList", user);
	}

	@Override
	public List<Users> queryList(Map<String, Object> condition) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("User.queryList", condition);
	}

	@Override
	public Integer queryCount(Map<String, Object> condition)
			throws SQLException {
		return sqlSessionTemplate.selectOne("User.queryTotalCount",condition);
	}


}
