package xflfk.wicresoft.dao;

import java.util.List;


import xfl.fk.sqldao.SqlControl;
import xflfk.wicresoft.entitry.LucyCfg;
import xflfk.wicresoft.factory.LuckyFactory;

@SuppressWarnings("all")
public class SqlDaoImpl implements SqlDao {
	private SqlControl sqlControl=LuckyFactory.getSqlControl();
	private Object object=null;
	private List<?> list=null;
	private boolean isOk=false;

	@Override
	public Object getOne(Class c, int id) {
		object=sqlControl.getOne(c, id);
		return object;
	}

	@Override
	public <T> List<?> getList(T t) {
		list=sqlControl.getList(t);
		return list;
	}

	@Override
	public <T> List<?> getPagList(T t, int index) {
		LucyCfg cfg=(LucyCfg) sqlControl.getOne(LucyCfg.class, 1);
		list=sqlControl.getPagList(t, index, cfg.getPagesize());
		return list;
	}

	@Override
	public List<?> getSqlList(Class c, String sql, Object... obj) {
		list=sqlControl.getList(c, sql, obj);
		return list;
	}

	@Override
	public List<?> getFuzzyList(Class c, String property, String info) {
		list=sqlControl.getFuzzyList(c, property, info);
		return list;
	}

	@Override
	public boolean deleteById(String tableName,int id) {
		isOk=sqlControl.delete(tableName, id);
		return isOk;
	}

	@Override
	public <T> boolean delete(T t) {
		isOk=sqlControl.delete(t);
		return isOk;
	}

	@Override
	public boolean delete(String sql, Object... obj) {
		isOk=sqlControl.delete(sql, obj);
		return isOk;
	}

	@Override
	public <T> boolean save(T t) {
		isOk=sqlControl.save(t);
		return isOk;
	}

	@Override
	public boolean save(String sql, Object... obj) {
		isOk=sqlControl.save(sql, obj);
		return isOk;
	}

	@Override
	public <T> boolean update(T t) {
		isOk=sqlControl.update(t);
		return isOk;
	}

	@Override
	public boolean update(String sql, Object... obj) {
		isOk=sqlControl.update(sql, obj);
		return isOk;
	}

}
