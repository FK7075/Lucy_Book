package xflfk.wicresoft.entitry;

import xflfk.wicresoft.dao.SqlDaoImpl;

/**
 * 辅助类——为分页操作提供数据
 * @author fk-7075
 *
 */
@SuppressWarnings("all")
public class PageInfo {
	/**
	 * 总记录数
	 */
	private int count;
	/**
	 * 当前页的第一条记录在表中的位置
	 */
	private int index;
	/**
	 * 页面总数
	 */
	private int pagenum;
	/**
	 * 每页显示的记录数
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
	 * 对象方式的构造器
	 * @param c
	 * 储存查询结果的容器
	 * @param t
	 * 包含分页查询信息的对象
	 * @param nowPageNum
	 * 当前页的页码
	 * @param size
	 * 每页显示的记录数
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
	 * 预编译Sql方式的构造器
	 * @param c
	 * 储存查询结果的容器
	 * @param nowPageNum
	 * 当前页的页码
	 * @param size
	 * 每页显示的记录数
	 * @param sql
	 * 预编译的Sql语句
	 * @param obj
	 * 填充占位符的对象数组
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
