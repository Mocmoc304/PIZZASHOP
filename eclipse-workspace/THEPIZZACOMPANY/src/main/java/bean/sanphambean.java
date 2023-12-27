package bean;

public class sanphambean {
	private String masanpham;
	private String tensanpham;
	private long gia;
	private String anh;
	private String noidung;
	private String madanhmuc;
	public sanphambean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public sanphambean(String masanpham, String tensanpham, long gia, String anh, String noidung, String madanhmuc) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.gia = gia;
		this.anh = anh;
		this.noidung = noidung;
		this.madanhmuc = madanhmuc;
	}
	public String getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(String masanpham) {
		this.masanpham = masanpham;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getMadanhmuc() {
		return madanhmuc;
	}
	public void setMadanhmuc(String madanhmuc) {
		this.madanhmuc = madanhmuc;
	}
	

}
