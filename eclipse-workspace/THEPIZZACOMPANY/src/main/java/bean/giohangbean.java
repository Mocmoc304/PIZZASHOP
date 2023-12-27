package bean;

public class giohangbean {
	private String masanpham;
	private String tensanpham;
	private Long gia;
	private String anh;
	private Long soluongmua;
	private Long thanhtien;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String masanpham, String tensanpham, Long gia, String anh, Long soluongmua) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.gia = gia;
		this.anh = anh;
		this.soluongmua = soluongmua;
		this.thanhtien= gia*soluongmua;
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
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public Long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(Long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public Long getThanhtien() {
		return soluongmua*gia;
	}
	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}
	

}
