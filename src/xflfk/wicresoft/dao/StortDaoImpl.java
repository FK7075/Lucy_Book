package xflfk.wicresoft.dao;

import java.util.List;

import org.apache.catalina.User;

import xflfk.wicresoft.entitry.Stort;
@SuppressWarnings("all")
public class StortDaoImpl implements SqlDao<Stort> {
	private boolean isOk=false;
	private Stort stort=null;
	private List<Stort> stortlist=null;

	@Override
	public Stort getOne(int id) {
		stort=(Stort) sqlControl.getOne(Stort.class, id);
		return stort;
	}

	@Override
	public boolean delete(int id) {
		String tableName=Stort.class.getSimpleName();
		if(sqlControl.delete(tableName, id))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean save(Stort t) {
		if(sqlControl.save(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(Stort t) {
		if(sqlControl.delete(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(Stort t) {
		if(sqlControl.update(t))
			isOk=true;
		return isOk;
	}

	@Override
	public List<Stort> getList(Stort t) {
		stortlist=(List<Stort>) sqlControl.getList(t);
		return stortlist;
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
	public List<Stort> getList(String sql, Object... obj) {
		stortlist=(List<Stort>) sqlControl.getList(Stort.class, sql, obj);
		return stortlist;
	}

	@Override
	public List<Stort> getPagList(Stort t, int index, int size) {
		stortlist=(List<Stort>) sqlControl.getPagList(t, index, size);
		return stortlist;
	}

	@Override
	public List<Stort> getSortList(Stort t, String property, int r) {
		stortlist=(List<Stort>) sqlControl.getSortList(t, property, r);
		return stortlist;
	}

	@Override
	public List<Stort> getFuzzyList(String property, String info) {
		stortlist=(List<Stort>) sqlControl.getFuzzyList(Stort.class, property, info);
		return stortlist;
	}

}
