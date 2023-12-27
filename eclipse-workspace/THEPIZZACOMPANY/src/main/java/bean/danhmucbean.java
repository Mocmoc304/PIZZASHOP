package bean;

public class danhmucbean {
	private String madanhmuc;
	private String tendanhmuc;
	public danhmucbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public danhmucbean(String madanhmuc, String tendanhmuc) {
		super();
		this.madanhmuc = madanhmuc;
		this.tendanhmuc = tendanhmuc;
	}
	public String getMadanhmuc() {
		return madanhmuc;
	}
	public void setMadanhmuc(String madanhmuc) {
		this.madanhmuc = madanhmuc;
	}
	public String getTendanhmuc() {
		return tendanhmuc;
	}
	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}
	

}
