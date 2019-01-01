package xflfk.wicresoft.factory;

import xfl.fk.sqldao.SqlControl;

public class LuckyFactory {
	private static SqlControl sql=null;
	/**
	 * 使用单例模式获得操作数据库的SqlControl对象
	 * @return
	 */
	public static SqlControl getSqlControl() {
		if(sql==null) {
			sql=new SqlControl();
		}
		return sql;
	}
	

}
