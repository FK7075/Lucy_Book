package xflfk.wicresoft.dao;

import java.util.List;

import xfl.fk.sqldao.SqlControl;
import xflfk.wicresoft.factory.LuckyUtils;

@SuppressWarnings("all") 
public interface SqlDao <T>  {
	public SqlControl sqlControl=LuckyUtils.getSqlControl();
	/**
	 * 通过ID查询数据
	 * @param id
	 * @return
	 */
	public T getOne(int id);
	/**
	 * 
	 * 通过ID删除数据
	 * @param id
	 * @return
	 */
	public boolean delete(int id);
	/**
	 * 保存数据
	 * @param t
	 * @return
	 */
	public boolean save(T t);
	/**
	 * 删除数据
	 * @param t
	 * @return
	 */
	public boolean delete(T t);
	/**
	 * 更新数据
	 * @param t
	 * @return
	 */
	public boolean update(T t);
	/**
	 * 查询数据
	 * @param t
	 * @return
	 */
	public List<T> getList(T t);
	/**
	 * 预编译sql添加数据
	 * @param sql
	 * @param obj
	 * @return
	 */
	public boolean save(String sql,Object...obj);
	/**
	 *  预编译sql删除数据
	 * @param sql
	 * @param obj
	 * @return
	 */
	public boolean delete(String sql,Object...obj);
	/**
	 *  预编译sql更新数据
	 * @param sql
	 * @param obj
	 * @return
	 */
	public boolean update(String sql,Object...obj);
	/**
	 *  预编译sql添查询数据
	 * @param c
	 * @param sql
	 * @param obj
	 * @return
	 */
	public List<T> getList(String sql,Object...obj);
	/**
	 * 分页查询
	 * @param t
	 * @param index
	 * 第一条数据在表中的位置
	 * @param size
	 * 每页的记录数
	 * @return
	 */
	public List<T> getPagList(T t,int index,int size);
	/**
	 * 排序查询
	 * @param t
	 * @param property
	 * 排序关键字
	 * @param r
	 * 排序方式（0-升序 1-降序）
	 * @return
	 */
	public List<T> getSortList(T t,String property,int r);
	/**
	 * 模糊查询
	 * @param c
	 * @param property
	 * 要查询的字段
	 * @param info
	 * 查询关键字
	 * @return
	 */
	public List<T> getFuzzyList(String property,String info);
	
	

}
