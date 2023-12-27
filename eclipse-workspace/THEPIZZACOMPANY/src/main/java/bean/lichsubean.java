package bean;

import java.util.Date;

public class lichsubean {
	private String masanpham;
	private String tensanpham;
	private long soluongmua;
	private long gia;
	private long makh;
	private long thanhtien;
	private Date ngaymua;
	private Boolean damua;
	private String anh;
	public lichsubean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public lichsubean(String masanpham, String tensanpham, long soluongmua, long gia, long makh, long thanhtien,
			Date ngaymua, Boolean damua, String anh) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.soluongmua = soluongmua;
		this.gia = gia;
		this.makh = makh;
		this.thanhtien = thanhtien;
		this.ngaymua = ngaymua;
		this.damua = damua;
		this.anh = anh;
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
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public Boolean getDamua() {
		return damua;
	}
	public void setDamua(Boolean damua) {
		this.damua = damua;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	

}
