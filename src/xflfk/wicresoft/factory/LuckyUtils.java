package xflfk.wicresoft.factory;

import xfl.fk.sqldao.SqlControl;

public class LuckyUtils {
	private static SqlControl sql=null;
	/**
	 * 获取Lucky操作数据库的SqlControl对象
	 * @return
	 */
	public static SqlControl getSqlControl() {
		if(sql==null){
			sql=new SqlControl();
		}
		return sql;
	}
}
