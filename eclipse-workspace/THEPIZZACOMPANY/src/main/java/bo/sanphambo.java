package bo;

import java.util.ArrayList;

import bean.sanphambean;
import dao.sanphamdao;

public class sanphambo {
	sanphamdao spdao = new sanphamdao();
	ArrayList<sanphambean> ds;
	 public ArrayList<sanphambean> getAll() {
		   return ds;
	   }
	 
	public ArrayList<sanphambean> getSanPham() throws Exception{
		ds = spdao.getSanPham();
		return ds;
	}
	public int getSLSanPham() throws Exception{
		return spdao.getSLSanPham();
	}
	public int getSLSanPhamcuaDM(String madm) throws Exception{
		return spdao.getSLSanPhamcuaDM(madm);
	}
	public int getSLSanPhamcuaSearch(String key) throws Exception{
		return spdao.getSLSanPhamcuaSearch(key);
	}
	public ArrayList<sanphambean> Pagination(int index) throws Exception{
		return spdao.Pagination(index);
	}
	public ArrayList<sanphambean> getChiTiet(String masp) throws Exception{
		ds = spdao.getChiTiet(masp);
		return ds;
	}
	public ArrayList<sanphambean> getSanPhamPopular() throws Exception{
		ds = spdao.getSanPhamPopular();
		return ds;
	}
	public ArrayList<sanphambean> getSanPhamToday() throws Exception{
		ds = spdao.getSanPhamToday();
		return ds;
	}
	
	public ArrayList<sanphambean> TimDanhMuc(String madm, int index) throws Exception{
		return spdao.TimDanhMuc(madm, index);
	}
	public ArrayList<sanphambean> Tim(String key, int index) throws Exception{
		return spdao.Tim(key, index);
	}
	public int Them(String masanpham, String tensanpham,long gia,String anh, String noidung,  String madanhmuc) throws Exception{
		getSanPham();
		for (sanphambean sp : ds) {
	   		if(sp.getMasanpham().equals(masanpham)) {
	   			return 0;
	   		}
	    			
	   		}   
	    	
	    	sanphambean sp = new sanphambean(masanpham, tensanpham, gia, anh, noidung, madanhmuc);
	    	ds.add(sp);
	    	spdao.Them(masanpham, tensanpham, gia, anh, noidung, madanhmuc);
	    	return 1;
	}
	public int Sua(String tensanpham,long gia,String anh, String noidung,  String madanhmuc,String masanpham) throws Exception {
		getSanPham();
		for (sanphambean sp : ds) {
			if (sp.getMasanpham().equals(masanpham)) { 
				sp.setTensanpham(tensanpham);;
				sp.setGia(gia);
				sp.setAnh(anh);
				sp.setAnh(noidung);
				sp.setMadanhmuc(madanhmuc);
				spdao.Sua(tensanpham, gia, anh, noidung, madanhmuc, masanpham);
				return 1;
			    }
		}
		return 0;
	}
	public int Xoa(String masanpham) throws Exception{
		getSanPham();
		for (sanphambean sp : ds) {
	   		if(sp.getMasanpham().equals(masanpham)) {
	   			ds.remove(sp);
	   			spdao.Xoa(masanpham);
	   			return 1;
	   		}
	   		
	    			
	   		}   
	    	
		return 0;
}
	public int Update(String madanhmuc) throws Exception{
		return spdao.Update(madanhmuc);
	}
}
