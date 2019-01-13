package xflfk.wicresoft.entitry;

public class Notes {//美文类
	private Integer bufid;
	private String article1;//内容1
	private String article2;//内容2
	public Integer getBufid() {
		return bufid;
	}
	public void setBufid(Integer bufid) {
		this.bufid = bufid;
	}
	public String getArticle1() {
		return article1;
	}
	public void setArticle1(String article1) {
		this.article1 = article1;
	}
	public String getArticle2() {
		return article2;
	}
	public void setArticle2(String article2) {
		this.article2 = article2;
	}
	@Override
	public String toString() {
		return "Notes [bufid=" + bufid + ", article1=" + article1 + ", article2=" + article2 + "]";
	}
	
}
