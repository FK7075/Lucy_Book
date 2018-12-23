package xflfk.wicresoft.dao;

import java.util.List;

import xflfk.wicresoft.entitry.Notes;


@SuppressWarnings("all")
public class NotesDaoImpl implements SqlDao<Notes> {
	private Notes note=null;
	private List<Notes> notelist=null;
	private boolean isOk=false;
	@Override
	public Notes getOne(int id) {
		note=(Notes) sqlControl.getOne(Notes.class, id);
		return note;
	}

	@Override
	public boolean delete(int id) {
		String tableName=Notes.class.getSimpleName();
		if(sqlControl.delete(tableName, id))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean save(Notes t) {
		if(sqlControl.save(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(Notes t) {
		if(sqlControl.delete(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(Notes t) {
		if(sqlControl.update(t))
			isOk=true;
		return isOk;
	}

	@Override
	public List<Notes> getList(Notes t) {
		notelist=(List<Notes>) sqlControl.getList(t);
		return notelist;
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
	public List<Notes> getList(String sql, Object... obj) {
		notelist=(List<Notes>) sqlControl.getList(Notes.class, sql, obj);
		return notelist;
	}

	@Override
	public List<Notes> getPagList(Notes t, int index, int size) {
		notelist=(List<Notes>) sqlControl.getPagList(t, index, size);
		return notelist;
	}

	@Override
	public List<Notes> getSortList(Notes t, String property, int r) {
		notelist=(List<Notes>) sqlControl.getSortList(t, property, r);
		return notelist;
	}

	@Override
	public List<Notes> getFuzzyList(String property, String info) {
		notelist=(List<Notes>) sqlControl.getFuzzyList(Notes.class , property, info);
		return notelist;
	}

}
