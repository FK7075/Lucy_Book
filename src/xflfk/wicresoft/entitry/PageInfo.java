package xflfk.wicresoft.entitry;

/**
 * �����ࡪ��Ϊ��ҳ�����ṩ����
 * @author fk-7075
 *
 */
public class PageInfo {
	private int count;//�ܼ�¼��
	private int index;//��ǰҳ�ĵ�һ����¼��λ��
	private int pagenum;//ҳ������
	private int size;//ÿҳ��ʾ�ļ�¼��
	
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
