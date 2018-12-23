package xflfk.wicresoft.dao;

import java.util.List;

import xflfk.wicresoft.entitry.Detail;

@SuppressWarnings("all")
public class DetailDaoImpl implements SqlDao<Detail> {
	private Detail detail=null;
	private List<Detail> detlist=null;
	private boolean isOk=false;

	@Override
	public Detail getOne(int id) {
		detail=(Detail) sqlControl.getOne(Detail.class , id);
		return detail;
	}

	@Override
	public boolean delete(int id) {
		String tableName=Detail.class.getSimpleName();
		if(sqlControl.delete(tableName, id))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean save(Detail t) {
		if(sqlControl.save(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(Detail t) {
		if(sqlControl.delete(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(Detail t) {
		if(sqlControl.update(t))
			isOk=true;
		return isOk;
	}


	@Override
	public List<Detail> getList(Detail t) {
		detlist=(List<Detail>) sqlControl.getList(t);
		return detlist;
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
	public List<Detail> getList(String sql, Object... obj) {
		detlist=(List<Detail>) sqlControl.getList(Detail.class , sql, obj);
		return detlist;
	}

	@Override
	public List<Detail> getPagList(Detail t, int index, int size) {
		detlist=(List<Detail>) sqlControl.getPagList(t, index, size);
		return detlist;
	}

	@Override
	public List<Detail> getSortList(Detail t, String property, int r) {
		detlist=(List<Detail>) sqlControl.getSortList(t, property, r);
		return detlist;
	}

	@Override
	public List<Detail> getFuzzyList(String property, String info) {
		detlist=(List<Detail>) sqlControl.getFuzzyList(Detail.class, property, info);
		return detlist;
	}

}
