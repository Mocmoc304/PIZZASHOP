package bo;

import java.util.ArrayList;


import bean.loginbean;
import dao.logindao;

public class loginbo {
	logindao logdao = new logindao();
	ArrayList<loginbean> ds;
	public ArrayList<loginbean> getAll() throws Exception{
		return ds;
	}
	public ArrayList<loginbean> getAdmin(String tendangnhap, String matkhau) throws Exception{
		ds= logdao.getAdmin(tendangnhap, matkhau);
		return ds;
	}
	public boolean kt(String tendangnhap, String matkhau) throws Exception {
		for(loginbean log : getAdmin(tendangnhap, matkhau)) {
			if( log.getTendangnhap().equals(tendangnhap)&&
					log.getMatkhau().equals(matkhau)) {
				return true;
			}
		}
		return false;
	}
}
