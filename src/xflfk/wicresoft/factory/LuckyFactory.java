package xflfk.wicresoft.factory;

import xfl.fk.sqldao.SqlControl;

/**
 * ����ģʽ����Lucky���ڲ������ݿ��SqlControl�����
 * @author fk-7075
 *
 */
public class LuckyFactory {
	private static SqlControl sql=null;
	private LuckyFactory() {};
	/**
	 * ���SqlControl����
	 * @return
	 */
	public static SqlControl getSqlControl() {
		if(sql==null) {
			sql=new SqlControl();
		}
		return sql;
	}
	

}
