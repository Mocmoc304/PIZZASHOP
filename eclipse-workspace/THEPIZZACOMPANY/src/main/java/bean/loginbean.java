package bean;

public class loginbean {
	private String tendangnhap;
	private String matkhau;
	private boolean quyen;
	private String anh;
	public loginbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public loginbean(String tendangnhap, String matkhau, boolean quyen, String anh) {
		super();
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.quyen = quyen;
		this.anh = anh;
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public boolean isQuyen() {
		return quyen;
	}
	public void setQuyen(boolean quyen) {
		this.quyen = quyen;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	

}
