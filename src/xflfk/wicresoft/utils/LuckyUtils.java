package xflfk.wicresoft.utils;

import xfl.fk.sqldao.SqlControl;

public class LuckyUtils {
	private static SqlControl sql=null;
	/**
	 * 获取Lucky操作数据库的SqlControl对象
	 * @return
	 */
	public static SqlControl getSqlControl() {
		sql=new SqlControl();
		return sql;
	}
}
