package xflfk.wicresoft.utils;

import xfl.fk.sqldao.SqlControl;

public class LuckyUtils {
	private static SqlControl sql=null;
	/**
	 * ��ȡLucky�������ݿ��SqlControl����
	 * @return
	 */
	public static SqlControl getSqlControl() {
		sql=new SqlControl();
		return sql;
	}
}
