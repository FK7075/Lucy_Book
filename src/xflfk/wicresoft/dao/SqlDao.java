package xflfk.wicresoft.dao;

import java.util.List;

@SuppressWarnings("all")
public interface SqlDao {
	/**
	 * 根据id得到表中的一条数据
	 * @param c
	 * 包装类的Class
	 * @param i
	 * 要查询表的的id
	 * @return
	 */
	public Object getOne(Class c,int id);
	/**
	 * 对象查询
	 * @param c
	 * 包装类的Class
	 * @param t
	 * 查询信息
	 * @return
	 */
	public <T> List<?> getList(T t);
	/**
	 * 分页查询
	 * @param c
	 * @param index
	 * @return
	 */
	public <T> List<?> getPagList(T t,int index);
	/**
	 * 预编译Sql语句查询
	 * @param c
	 * 包装类的Class
	 * @param sql
	 * 预编译的Sql语句
	 * @param obj
	 * 填充占位符(?)的对象数组
	 * @return
	 */
	public List<?> getSqlList(Class c,String sql,Object...obj);
	/**
	 * 简单模糊查询
	 * @param c
	 * 包装类的Class
	 * @param property
	 * 要查询的字段
	 * @param info
	 * 查询关键字
	 * @return
	 */
	public List<?> getFuzzyList(Class c,String property,String info);
	/**
	 * Id删除
	 * @param id
	 * @return
	 */
	public boolean deleteById(String tableName,int id);
	/**
	 * 对象删除
	 * @param t
	 * @return
	 */
	public <T> boolean delete(T t);
	/**
	 * 预编译Sql删除
	 * @param sql
	 * @param obj
	 * @return
	 */
	public boolean delete(String sql,Object...obj);
	/**
	 * 对象方式保存
	 * @param t
	 * @return
	 */
	public <T> boolean save(T t);
	/**
	 * 预编译Sql保存
	 * @param sql
	 * @param obj
	 * @return
	 */
	public boolean save(String sql,Object...obj); 
	/**
	 * 对象方式修改
	 * @param t
	 * @return
	 */
	public <T> boolean update(T t);
	/**
	 * 预编译Sql修改
	 * @param sql
	 * @param obj
	 * @return
	 */
	public boolean update(String sql,Object...obj); 

}
