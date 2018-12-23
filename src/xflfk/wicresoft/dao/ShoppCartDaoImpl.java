package xflfk.wicresoft.dao;

import java.util.List;

import xflfk.wicresoft.entitry.ShoppCart;

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
		
		return isOk;
	}

	@Override
	public boolean delete(ShoppCart t) {
		// TODO Auto-generated method stub
		return isOk;
	}

	@Override
	public boolean update(ShoppCart t) {
		// TODO Auto-generated method stub
		return isOk;
	}

	@Override
	public List<ShoppCart> getList(ShoppCart t) {
		// TODO Auto-generated method stub
		return shopplist;
	}

	@Override
	public boolean save(String sql, Object... obj) {
		// TODO Auto-generated method stub
		return isOk;
	}

	@Override
	public boolean delete(String sql, Object... obj) {
		// TODO Auto-generated method stub
		return isOk;
	}

	@Override
	public boolean update(String sql, Object... obj) {
		// TODO Auto-generated method stub
		return isOk;
	}

	@Override
	public List<ShoppCart> getList(String sql, Object... obj) {
		// TODO Auto-generated method stub
		return shopplist;
	}

	@Override
	public List<ShoppCart> getPagList(ShoppCart t, int index, int size) {
		// TODO Auto-generated method stub
		return shopplist;
	}

	@Override
	public List<ShoppCart> getSortList(ShoppCart t, String property, int r) {
		// TODO Auto-generated method stub
		return shopplist;
	}

	@Override
	public List<ShoppCart> getFuzzyList(String property, String info) {
		// TODO Auto-generated method stub
		return shopplist;
	}

}
