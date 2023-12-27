package bean;

public class khachhangbean {
	private long makh;
	private String hoten;
	private String diachi;
	private String sodienthoai;
	private String email;
	private String tendn;
	private String password;
	public khachhangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public khachhangbean(long makh, String hoten, String diachi, String sodienthoai, String email, String tendn,
			String password) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
		this.email = email;
		this.tendn = tendn;
		this.password = password;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTendn() {
		return tendn;
	}
	public void setTendn(String tendn) {
		this.tendn = tendn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
