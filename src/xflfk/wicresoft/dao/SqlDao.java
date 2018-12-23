package xflfk.wicresoft.dao;

import java.util.List;

import xfl.fk.sqldao.SqlControl;
import xflfk.wicresoft.factory.LuckyUtils;

@SuppressWarnings("all") 
public interface SqlDao <T>  {
	public SqlControl sqlControl=LuckyUtils.getSqlControl();
	/**
	 * ͨ��ID��ѯ����
	 * @param id
	 * @return
	 */
	public T getOne(int id);
	/**
	 * 
	 * ͨ��IDɾ������
	 * @param id
	 * @return
	 */
	public boolean delete(int id);
	/**
	 * ��������
	 * @param t
	 * @return
	 */
	public boolean save(T t);
	/**
	 * ɾ������
	 * @param t
	 * @return
	 */
	public boolean delete(T t);
	/**
	 * ��������
	 * @param t
	 * @return
	 */
	public boolean update(T t);
	/**
	 * ��ѯ����
	 * @param t
	 * @return
	 */
	public List<T> getList(T t);
	/**
	 * Ԥ����sql�������
	 * @param sql
	 * @param obj
	 * @return
	 */
	public boolean save(String sql,Object...obj);
	/**
	 *  Ԥ����sqlɾ������
	 * @param sql
	 * @param obj
	 * @return
	 */
	public boolean delete(String sql,Object...obj);
	/**
	 *  Ԥ����sql��������
	 * @param sql
	 * @param obj
	 * @return
	 */
	public boolean update(String sql,Object...obj);
	/**
	 *  Ԥ����sql���ѯ����
	 * @param c
	 * @param sql
	 * @param obj
	 * @return
	 */
	public List<T> getList(String sql,Object...obj);
	/**
	 * ��ҳ��ѯ
	 * @param t
	 * @param index
	 * ��һ�������ڱ��е�λ��
	 * @param size
	 * ÿҳ�ļ�¼��
	 * @return
	 */
	public List<T> getPagList(T t,int index,int size);
	/**
	 * �����ѯ
	 * @param t
	 * @param property
	 * ����ؼ���
	 * @param r
	 * ����ʽ��0-���� 1-����
	 * @return
	 */
	public List<T> getSortList(T t,String property,int r);
	/**
	 * ģ����ѯ
	 * @param c
	 * @param property
	 * Ҫ��ѯ���ֶ�
	 * @param info
	 * ��ѯ�ؼ���
	 * @return
	 */
	public List<T> getFuzzyList(String property,String info);
	
	

}
