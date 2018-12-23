package xflfk.wicresoft.dao;

import java.util.List;

import xfl.fk.sqldao.SqlControl;
import xflfk.wicresoft.entitry.Author;
import xflfk.wicresoft.factory.LuckyUtils;

@SuppressWarnings("all") 
public class AuthorDaoImpl implements SqlDao<Author> {
	private boolean isOk=false;
	private Author author=null;
	private List<Author> autlist=null;


	@Override
	public Author getOne(int id) {
		author=(Author) sqlControl.getOne(Author.class, id);
		return author;
	}

	@Override
	public boolean delete(int id) {
		String tableName=Author.class.getSimpleName();
		if(sqlControl.delete(tableName, id))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean save(Author t) {
		if(sqlControl.save(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(Author t) {
		if(sqlControl.delete(t))
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(Author t) {
		if(sqlControl.update(t))
			isOk=true;
		return isOk;
	}

	@Override
	public List<Author> getList(Author t) {
		autlist=(List<Author>) sqlControl.getList(t);
		return autlist;
	}

	@Override
	public boolean save(String sql, Object... obj) {
		if(sqlControl.save(sql, obj));
			isOk=true;
		return isOk;
	}

	@Override
	public boolean delete(String sql, Object... obj) {
		if(sqlControl.delete(sql, obj));
			isOk=true;
		return isOk;
	}

	@Override
	public boolean update(String sql, Object... obj) {
		if(sqlControl.update(sql, obj));
			isOk=true;
		return isOk;
	}

	@Override
	public List<Author> getList(String sql, Object... obj) {
		autlist=(List<Author>) sqlControl.getList(Author.class, sql, obj);
		return autlist;
	}

	@Override
	public List<Author> getPagList(Author t, int index, int size) {
		autlist=(List<Author>) sqlControl.getPagList(t, index, size);
		return autlist;
	}

	@Override
	public List<Author> getSortList(Author t, String property, int r) {
		autlist=(List<Author>) sqlControl.getSortList(t, property, r);
		return autlist;
	}

	@Override
	public List<Author> getFuzzyList(String property, String info) {
		autlist=(List<Author>) sqlControl.getFuzzyList(Author.class, property, info);
		return autlist;
	}

}
