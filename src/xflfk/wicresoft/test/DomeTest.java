package xflfk.wicresoft.test;

import xfl.fk.sqldao.Transaction;
import xflfk.wicresoft.dao.AuthorDaoImpl;
import xflfk.wicresoft.dao.SqlDao;
import xflfk.wicresoft.entitry.Author;

public class DomeTest {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		SqlDao<Author> sqlDao=new AuthorDaoImpl();
		Transaction tx=null;
		try {
			tx=sqlDao.sqlControl.openTransaction();
			Author a1=sqlDao.getOne(1);
			Author a2=sqlDao.getOne(2);
			a1.setAutName("ppp");
			a2.setAutName("lucy");
			sqlDao.update(a1);
//			int i=1/0;
			sqlDao.update(a2); 
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
