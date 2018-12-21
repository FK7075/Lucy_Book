package xflfk.wicresoft.dao;

import java.util.ArrayList;
import java.util.List;

import xfl.fk.sqldao.SqlControl;
import xflfk.wicresoft.entitry.Admin;
import xflfk.wicresoft.utils.LuckyUtils;

@SuppressWarnings("all") 
public class AdminDaoImpl implements SqlDao<Admin> {
	private SqlControl sqlControl;
	private Admin admin=null;
	private boolean isOk=false;
	private List<Admin> admlist=null;
	public AdminDaoImpl() {
		sqlControl=LuckyUtils.getSqlControl();
	}

	@Override
	public Admin getOne(int id) {
		admin=(Admin) sqlControl.getOne(Admin.class, id);
		return admin;
	}

	@Override
	public boolean delete(int id) {
		String tableName=Admin.class.getSimpleName();
		if(sqlControl.delete(tableName, id))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean save(Admin t) {
		if(sqlControl.save(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(Admin t) {
		if(sqlControl.delete(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(Admin t) {
		if(sqlControl.update(t))
			isOk=true;
		return isOk;
	}

	@Override
	public List<Admin> getList(Admin t) {
		admlist=(List<Admin>) sqlControl.getList(t);
		return admlist;
	}

	@Override
	public boolean save(String sql, Object... obj) {
		if(sqlControl.save(sql, obj))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(String sql, Object... obj) {
		if(sqlControl.delete(sql, obj))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(String sql, Object... obj) {
		if(sqlControl.update(sql, obj))
			isOk=true;
		return isOk;
	}

	@Override
	public List<Admin> getList(String sql, Object... obj) {
		admlist=(List<Admin>) sqlControl.getList(Admin.class, sql, obj);
		return admlist;
	}

	@Override
	public List<Admin> getPagList(Admin t, int index, int size) {
		admlist=(List<Admin>) sqlControl.getPagList(t, index, size);
		return admlist;
	}

	@Override
	public List<Admin> getSortList(Admin t, String property, int r) {
		admlist=(List<Admin>) sqlControl.getSortList(t, property, r);
		return admlist;
	}

	@Override
	public List<Admin> getFuzzyList(String property, String info) {
		admlist=(List<Admin>) sqlControl.getFuzzyList(Admin.class, property, info);
		return admlist;
	}

}
