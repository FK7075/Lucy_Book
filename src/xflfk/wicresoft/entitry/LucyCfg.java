package xflfk.wicresoft.entitry;

/**
 * ʵ���ࡪ����վ����
 * @author fk-7075
 *
 */
public class LucyCfg {
	private Integer cfgid;
	private Integer pagesize;//��ҳҳ��
	private Integer inventory;//��澯����
	private Integer showStort1;//ǰ̨չʾ����1
	private Integer showStort2;//ǰ̨չʾ����2
	private Integer showStort3;//ǰ̨չʾ����3
	private Integer showStort4;//ǰ̨չʾ����4

	public Integer getShowStort1() {
		return showStort1;
	}
	public void setShowStort1(Integer showStort1) {
		this.showStort1 = showStort1;
	}
	public Integer getShowStort2() {
		return showStort2;
	}
	public void setShowStort2(Integer showStort2) {
		this.showStort2 = showStort2;
	}
	public Integer getShowStort3() {
		return showStort3;
	}
	public void setShowStort3(Integer showStort3) {
		this.showStort3 = showStort3;
	}
	public Integer getShowStort4() {
		return showStort4;
	}
	public void setShowStort4(Integer showStort4) {
		this.showStort4 = showStort4;
	}
	public Integer getCfgid() {
		return cfgid;
	}
	public void setCfgid(Integer cfgid) {
		this.cfgid = cfgid;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	@Override
	public String toString() {
		return "LucyCfg [cfgid=" + cfgid + ", pagesize=" + pagesize + ", inventory=" + inventory + ", showStort1="
				+ showStort1 + ", showStort2=" + showStort2 + ", showStort3=" + showStort3 + ", showStort4="
				+ showStort4 + "]";
	}

}
