package xflfk.wicresoft.dao;

import java.util.List;

import xflfk.wicresoft.entitry.ShoppCart;

@SuppressWarnings("all")
public class ShoppCartDaoImpl implements SqlDao<ShoppCart> {
	private ShoppCart shopp=null;
	private List<ShoppCart> shopplist=null;
	private boolean isOk=false;

	@Override
	public ShoppCart getOne(int id) {
		shopp=(ShoppCart) sqlControl.getOne(ShoppCart.class , id);
		return shopp;
	}

	@Override
	public boolean delete(int id) {
		String tableName=ShoppCart.class.getSimpleName();
		if(sqlControl.delete(tableName, id))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean save(ShoppCart t) {
		if(sqlControl.save(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(ShoppCart t) {
		if(sqlControl.delete(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(ShoppCart t) {
		if(sqlControl.update(t))
			isOk=true;
		return isOk;
	}

	@Override
	public List<ShoppCart> getList(ShoppCart t) {
		shopplist=(List<ShoppCart>) sqlControl.getList(t);
		return shopplist;
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
	public List<ShoppCart> getList(String sql, Object... obj) {
		shopplist=(List<ShoppCart>) sqlControl.getList(ShoppCart.class, sql, obj);
		return shopplist;
	}

	@Override
	public List<ShoppCart> getPagList(ShoppCart t, int index, int size) {
		shopplist=(List<ShoppCart>) sqlControl.getPagList(t, index, size);
		return shopplist;
	}

	@Override
	public List<ShoppCart> getSortList(ShoppCart t, String property, int r) {
		shopplist=(List<ShoppCart>) sqlControl.getSortList(t, property, r);
		return shopplist;
	}

	@Override
	public List<ShoppCart> getFuzzyList(String property, String info) {
		shopplist=(List<ShoppCart>) sqlControl.getFuzzyList(ShoppCart.class, property, info);
		return shopplist;
	}

}
