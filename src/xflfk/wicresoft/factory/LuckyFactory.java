package xflfk.wicresoft.factory;

import xfl.fk.sqldao.SqlControl;

public class LuckyFactory {
	private static SqlControl sql=null;
	/**
	 * ʹ�õ���ģʽ��ò������ݿ��SqlControl����
	 * @return
	 */
	public static SqlControl getSqlControl() {
		if(sql==null) {
			sql=new SqlControl();
		}
		return sql;
	}
	

}
