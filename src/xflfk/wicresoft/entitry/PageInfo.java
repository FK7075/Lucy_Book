package xflfk.wicresoft.entitry;

import xflfk.wicresoft.dao.SqlDaoImpl;

/**
 * �����ࡪ��Ϊ��ҳ�����ṩ����
 * @author fk-7075
 *
 */
@SuppressWarnings("all")
public class PageInfo {
	/**
	 * �ܼ�¼��
	 */
	private int count;
	/**
	 * ��ǰҳ�ĵ�һ����¼�ڱ��е�λ��
	 */
	private int index;
	/**
	 * ҳ������
	 */
	private int pagenum;
	/**
	 * ÿҳ��ʾ�ļ�¼��
	 */
	private int size;
	private SqlDaoImpl sqlDao=new SqlDaoImpl();
	private Admin admin=new Admin();
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	@Override
	public String toString() {
		return "PageInfo [count=" + count + ", index=" + index + ", pagenum=" + pagenum + ", size=" + size + "]";
	}
	
	public PageInfo(Admin adm) {
		this.admin=adm;
	}
	
	/**
	 * ����ʽ�Ĺ�����
	 * @param c
	 * �����ѯ���������
	 * @param t
	 * ������ҳ��ѯ��Ϣ�Ķ���
	 * @param nowPageNum
	 * ��ǰҳ��ҳ��
	 * @param size
	 * ÿҳ��ʾ�ļ�¼��
	 */
	public <T> PageInfo(Class c,T t,int nowPageNum,int size) {
		this.count=sqlDao.getList(t).size();
		this.size=size;
		if(count%size==0)
			this.pagenum=count/size;
		else
			this.pagenum=(count/size)+1;
		this.index=(nowPageNum-1)*size;
		
	}
	
	/**
	 * Ԥ����Sql��ʽ�Ĺ�����
	 * @param c
	 * �����ѯ���������
	 * @param nowPageNum
	 * ��ǰҳ��ҳ��
	 * @param size
	 * ÿҳ��ʾ�ļ�¼��
	 * @param sql
	 * Ԥ�����Sql���
	 * @param obj
	 * ���ռλ���Ķ�������
	 */
	public PageInfo(Class c,int nowPageNum,int size,String sql,Object...obj) {
		this.count=sqlDao.getSqlList(c, sql, obj).size();
		this.size=size;
		if(count%size==0)
			this.pagenum=count/size;
		else
			this.pagenum=(count/size)+1;
		this.index=(nowPageNum-1)*size;
	}
}
