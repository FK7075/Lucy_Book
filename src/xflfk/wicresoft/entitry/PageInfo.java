package xflfk.wicresoft.entitry;

/**
 * 辅助类——为分页操作提供数据
 * @author fk-7075
 *
 */
public class PageInfo {
	private int count;//总记录数
	private int index;//当前页的第一条记录的位置
	private int pagenum;//页面总数
	private int size;//每页显示的记录数
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	@Override
	public String toString() {
		return "PageInfo [count=" + count + ", index=" + index + ", pagenum=" + pagenum + ", size=" + size + "]";
	}

}
