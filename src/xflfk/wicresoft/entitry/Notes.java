package xflfk.wicresoft.entitry;

public class Notes {//美文类
	private Integer bufid;
	private String content;//内容
	public Integer getBufid() {
		return bufid;
	}
	public void setBufid(Integer bufid) {
		this.bufid = bufid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Notes [bufid=" + bufid + ", content=" + content + "]";
	}
	

}
