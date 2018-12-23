package xflfk.wicresoft.dao;

import java.util.List;

import xflfk.wicresoft.entitry.Orders;

@SuppressWarnings("all")
public class OrdersDaoImpl implements SqlDao<Orders> {
	private Orders order=null;
	private List<Orders> ordlist=null;
	private boolean isOk=false;

	@Override
	public Orders getOne(int id) {
		order=(Orders) sqlControl.getOne(Orders.class, id);
		return order;
	}

	@Override
	public boolean delete(int id) {
		String tableName=Orders.class.getSimpleName();
		if(sqlControl.delete(tableName, id))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean save(Orders t) {
		if(sqlControl.save(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(Orders t) {
		if(sqlControl.delete(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(Orders t) {
		if(sqlControl.update(t))
			isOk=true;
		return isOk;
	}

	@Override
	public List<Orders> getList(Orders t) {
		ordlist=(List<Orders>) sqlControl.getList(t);
		return ordlist;
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
	public List<Orders> getList(String sql, Object... obj) {
		ordlist=(List<Orders>) sqlControl.getList(Orders.class , sql, obj);
		return ordlist;
	}

	@Override
	public List<Orders> getPagList(Orders t, int index, int size) {
		ordlist=(List<Orders>) sqlControl.getPagList(t, index, size);
		return ordlist;
	}

	@Override
	public List<Orders> getSortList(Orders t, String property, int r) {
		ordlist=(List<Orders>) sqlControl.getSortList(t, property, r);
		return ordlist;
	}

	@Override
	public List<Orders> getFuzzyList(String property, String info) {
		ordlist=(List<Orders>) sqlControl.getFuzzyList(Orders.class , property, info);
		return ordlist;
	}

}
