package xflfk.wicresoft.dao;

import java.util.List;

import xflfk.wicresoft.entitry.User;

@SuppressWarnings("all")
public class UserDaoImpl implements SqlDao<User> {
	private boolean isOk=false;
	private User user=null;
	private List<User> userlist=null;

	@Override
	public User getOne(int id) {
		user=(User) sqlControl.getOne(User.class, id);
		return user;
	}

	@Override
	public boolean delete(int id) {
		String tableName=User.class.getSimpleName();
		if(sqlControl.delete(tableName, id))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean save(User t) {
		if(sqlControl.save(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(User t) {
		if(sqlControl.delete(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(User t) {
		if(sqlControl.update(t))
			isOk=true;
		return isOk;
	}

	@Override
	public List<User> getList(User t) {
		userlist=(List<User>) sqlControl.getList(t);
		return userlist;
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
	public List<User> getList(String sql, Object... obj) {
		userlist=(List<User>) sqlControl.getList(User.class, sql, obj);
		return userlist;
	}

	@Override
	public List<User> getPagList(User t, int index, int size) {
		userlist=(List<User>) sqlControl.getPagList(t, index, size);
		return userlist;
	}

	@Override
	public List<User> getSortList(User t, String property, int r) {
		userlist=(List<User>) sqlControl.getSortList(t, property, r);
		return userlist;
	}

	@Override
	public List<User> getFuzzyList(String property, String info) {
		userlist=(List<User>) sqlControl.getFuzzyList(User.class, property, info);
		return userlist;
	}

}
