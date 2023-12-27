package bean;

public class adminxacnhanbean {
	private long machitiethd;
	private String hoten;
	private String tensanpham;
	private long gia;
	private long soluongmua;
	private long thanhtien;
	private boolean danmua;
	public adminxacnhanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public adminxacnhanbean(long machitiethd, String hoten, String tensanpham, long gia, long soluongmua,
			long thanhtien, boolean danmua) {
		super();
		this.machitiethd = machitiethd;
		this.hoten = hoten;
		this.tensanpham = tensanpham;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.thanhtien = thanhtien;
		this.danmua = danmua;
	}
	public long getMachitiethd() {
		return machitiethd;
	}
	public void setMachitiethd(long machitiethd) {
		this.machitiethd = machitiethd;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
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
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public boolean isDanmua() {
		return danmua;
	}
	public void setDanmua(boolean danmua) {
		this.danmua = danmua;
	}
	

}
