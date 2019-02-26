package xflfk.wicresoft.factory;

import xfl.fk.sqldao.SqlControl;

/**
 * 单例模式创建Lucky用于操作数据库的SqlControl类对象
 * @author fk-7075
 *
 */
public class LuckyFactory {
	private static SqlControl sql=null;
	private LuckyFactory() {};
	/**
	 * 获得SqlControl对象
	 * @return
	 */
	public static SqlControl getSqlControl() {
		if(sql==null) {
			sql=new SqlControl();
		}
		return sql;
	}
	

}
