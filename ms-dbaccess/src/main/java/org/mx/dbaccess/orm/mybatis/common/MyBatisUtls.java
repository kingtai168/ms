package org.mx.dbaccess.orm.mybatis.common;

import org.mx.basecomponent.utils.ReflectionUtils;
import org.mx.dbaccess.orm.mybatis.impl.BaseDaoImpl;

public class MyBatisUtls {
	
	
	public String sqlName;
	public static final String SQLNAME_SEPARATOR = ".";
	private static Class<?> SuperGenericClass = BaseDaoImpl.class;
	
	public static String getSqlName(String sqlName) {
		return getDefaultSqlNamespace(SuperGenericClass) + SQLNAME_SEPARATOR + sqlName;
	}

	public void setSqlName(String sqlName) {
		this.sqlName = sqlName;
	}

	@SuppressWarnings("rawtypes")
	protected static String getDefaultSqlNamespace(Class clazz) {
		Class<?> genericClass = ReflectionUtils.getSuperGenericType(clazz);
		return genericClass == null ? null : genericClass.getName();
	}

}
