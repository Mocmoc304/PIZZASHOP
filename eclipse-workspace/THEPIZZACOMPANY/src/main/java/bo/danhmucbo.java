package bo;

import java.util.ArrayList;

import bean.danhmucbean;
import dao.danhmucdao;

public class danhmucbo {
	danhmucdao dmdao= new danhmucdao();
	ArrayList<danhmucbean> ds;
	public ArrayList<danhmucbean> getDanhMuc() throws Exception {
		ds = dmdao.getDanhMuc();
		return ds;
	}
	public boolean  ktDanhMuc(String madanhmuc)throws Exception{
		return dmdao.ktDanhMuc(madanhmuc);
	}
	public ArrayList<danhmucbean> getChiTiet(String madm) throws Exception{
		ds = dmdao.getChiTiet(madm);
		return ds;
	}
	public int Them(String madanhmuc, String tendanhmuc) throws Exception{
		getDanhMuc();
		for (danhmucbean dm : ds) {
	   		if(dm.getMadanhmuc().equals(madanhmuc)) {
	   			return 0;
	   		}
	    			
	   		}   
	    	
	    	danhmucbean dm = new danhmucbean(madanhmuc, tendanhmuc);
	    	ds.add(dm);
	    	dmdao.Them(madanhmuc, tendanhmuc);
	    	return 1;
	}
	public int Sua(String tendanhmuc, String madanhmuc) throws Exception {
		getDanhMuc();
		for (danhmucbean dm : ds) {
			if (dm.getMadanhmuc().equals(madanhmuc)) { 
				dm.setTendanhmuc(tendanhmuc);
				dmdao.Sua(tendanhmuc, madanhmuc);
				return 1;
			    }
		}
		return 0;
	}
	public int Xoa(String madanhmuc) throws Exception{
		getDanhMuc();
		for (danhmucbean dm : ds) {
	   		if(dm.getMadanhmuc().equals(madanhmuc)) {
	   			ds.remove(dm);
	   			dmdao.Xoa(madanhmuc);
	   			return 1;
	   		}
	   		
	    			
	   		}   
	    	
		return 0;
}
	
}
