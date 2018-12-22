package xflfk.wicresoft.dao;

import java.util.List;

import xfl.fk.sqldao.SqlControl;
import xflfk.wicresoft.entitry.Consigness;

@SuppressWarnings("all")
public class ConsignessDaoImpl implements SqlDao<Consigness> {
	private Consigness cons=null;
	private List<Consigness> conslist=null;
	private boolean isOk=false;

	@Override
	public Consigness getOne(int id) {
		cons=(Consigness) sqlControl.getOne(Consigness.class, id);
		return cons;
	}

	@Override
	public boolean delete(int id) {
		String tableNam=Consigness.class.getSimpleName();
		if(sqlControl.delete(tableNam,id))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean save(Consigness t) {
		if(sqlControl.save(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(Consigness t) {
		if(sqlControl.delete(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(Consigness t) {
		if(sqlControl.update(t))
			isOk=true;
		return isOk;
	}

	@Override
	public List<Consigness> getList(Consigness t) {
		conslist = (List<Consigness>) sqlControl.getList(t);
		return conslist;
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
	public List<Consigness> getList(String sql, Object... obj) {
		conslist=(List<Consigness>) sqlControl.getList(Consigness.class, sql, obj);
		return conslist;
	}

	@Override
	public List<Consigness> getPagList(Consigness t, int index, int size) {
		conslist=(List<Consigness>) sqlControl.getPagList(t, index, size);
		return conslist;
	}

	@Override
	public List<Consigness> getSortList(Consigness t, String property, int r) {
		conslist=(List<Consigness>) sqlControl.getSortList(t, property, r);
		return conslist;
	}

	@Override
	public List<Consigness> getFuzzyList(String property, String info) {
		conslist=(List<Consigness>) sqlControl.getFuzzyList(Consigness.class, property, info);
		return conslist;
	}

}
