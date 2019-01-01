package xflfk.wicresoft.dao;

import java.util.List;

@SuppressWarnings("all")
public interface SqlDao {
	/**
	 * ����id�õ����е�һ������
	 * @param c
	 * ��װ���Class
	 * @param i
	 * Ҫ��ѯ��ĵ�id
	 * @return
	 */
	public Object getOne(Class c,int id);
	/**
	 * �����ѯ
	 * @param c
	 * ��װ���Class
	 * @param t
	 * ��ѯ��Ϣ
	 * @return
	 */
	public <T> List<?> getList(T t);
	/**
	 * ��ҳ��ѯ
	 * @param c
	 * @param index
	 * @return
	 */
	public <T> List<?> getPagList(T t,int index);
	/**
	 * Ԥ����Sql����ѯ
	 * @param c
	 * ��װ���Class
	 * @param sql
	 * Ԥ�����Sql���
	 * @param obj
	 * ���ռλ��(?)�Ķ�������
	 * @return
	 */
	public List<?> getSqlList(Class c,String sql,Object...obj);
	/**
	 * ��ģ����ѯ
	 * @param c
	 * ��װ���Class
	 * @param property
	 * Ҫ��ѯ���ֶ�
	 * @param info
	 * ��ѯ�ؼ���
	 * @return
	 */
	public List<?> getFuzzyList(Class c,String property,String info);
	/**
	 * Idɾ��
	 * @param id
	 * @return
	 */
	public boolean deleteById(String tableName,int id);
	/**
	 * ����ɾ��
	 * @param t
	 * @return
	 */
	public <T> boolean delete(T t);
	/**
	 * Ԥ����Sqlɾ��
	 * @param sql
	 * @param obj
	 * @return
	 */
	public boolean delete(String sql,Object...obj);
	/**
	 * ����ʽ����
	 * @param t
	 * @return
	 */
	public <T> boolean save(T t);
	/**
	 * Ԥ����Sql����
	 * @param sql
	 * @param obj
	 * @return
	 */
	public boolean save(String sql,Object...obj); 
	/**
	 * ����ʽ�޸�
	 * @param t
	 * @return
	 */
	public <T> boolean update(T t);
	/**
	 * Ԥ����Sql�޸�
	 * @param sql
	 * @param obj
	 * @return
	 */
	public boolean update(String sql,Object...obj); 

}
