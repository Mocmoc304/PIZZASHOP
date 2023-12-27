package bo;

import java.util.ArrayList;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	khachhangdao khdao = new khachhangdao();
	ArrayList<khachhangbean> ds;
	public ArrayList<khachhangbean> getAll() throws Exception{
		return ds;
	}
	public khachhangbean getThongTinkh(String mkh) throws Exception {
		return khdao.getThongTinkh(mkh);
	}
	public khachhangbean getThongTin(String tendn, String password) throws Exception {
	 return khdao.getThongTin(tendn, password);
	}
	public ArrayList<khachhangbean> getKhachhang(String tendn, String pass) throws Exception{
		ds= khdao.getKhachang(tendn, pass);
		return ds;
	}
	public boolean kt(String tendn, String pass) throws Exception {
		for(khachhangbean kh : getKhachhang(tendn, pass)) {
			if( kh.getTendn().equals(tendn)&&
					kh.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	public boolean  ktDangKy(String tendn)throws Exception{
		return khdao.ktDangKy(tendn);
	}
	public int AddKhachhang(String hoten, String email,String tendn, String pass) throws Exception {
		return khdao.AddKhachhang(hoten, email, tendn, pass);
	}

}
