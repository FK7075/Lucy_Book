package xflfk.wicresoft.dao;

import java.util.List;

import xfl.fk.sqldao.SqlControl;

@SuppressWarnings("all")
public class SqlDaoImpl {
	private Class c;
	private SqlControl sqlControl;
	public SqlDaoImpl(Class c) {
		this.c=c;
		sqlControl=new SqlControl();
	}
	/**
	 * ∏¥‘”≤È—Ø
	 * @param sql
	 * @param obj
	 * @return
	 */
	public List<?> getListSql(String sql,Object...obj) {
		return sqlControl.getList(c, sql, obj);
	}
}
