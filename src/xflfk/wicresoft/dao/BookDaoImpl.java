package xflfk.wicresoft.dao;

import java.util.List;

import xflfk.wicresoft.entitry.Book;

@SuppressWarnings("all") 
public class BookDaoImpl implements SqlDao<Book> {

	@Override
	public Book getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(Book t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Book t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Book t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> getList(Book t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(String sql, Object... obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String sql, Object... obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String sql, Object... obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> getList(String sql, Object... obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getPagList(Book t, int index, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getSortList(Book t, String property, int r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getFuzzyList(String property, String info) {
		// TODO Auto-generated method stub
		return null;
	}

}
