package xflfk.wicresoft.factory;

import xfl.fk.sqldao.SqlControl;

public class LuckyUtils {
	private static SqlControl sql=null;
	/**
	 * ��ȡLucky�������ݿ��SqlControl����
	 * @return
	 */
	public static SqlControl getSqlControl() {
		if(sql==null){
			sql=new SqlControl();
		}
		return sql;
	}
}
