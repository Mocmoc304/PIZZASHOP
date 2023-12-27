package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loginbean;

public class logindao {
	public ArrayList<loginbean> getAdmin(String tendangnhap, String matkhau) throws Exception {
		ArrayList<loginbean> ds = new ArrayList<loginbean>();
		// b1 ket noi vao csdl: QlSach
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2 tao cau lenh sql
		String sql = "select * from DangNhap where TenDangNhap=? and MatKhau=?";
		// b3 tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendangnhap);
		cmd.setString(2, matkhau);
		// b4 truyen tham so vao cau lenh neu co
		// b5 thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String username = rs.getString("tendangnhap");
			String password = rs.getString("matkhau");
			Boolean quyen = rs.getBoolean("quyen");
			String anh = rs.getString("anh");
			ds.add(new loginbean(username, password, quyen,anh));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public boolean  kt(String tendangnhap, String matkhau)throws Exception  { 
		   try{ 
			   KetNoi kn = new KetNoi();
				kn.ketnoi();  
		     String sql="select * from DangNhap where TenDangNhap=? and MatKhau=?"; 
		     PreparedStatement cmd= kn.cn.prepareStatement(sql) ; 
		     cmd.setString(1, tendangnhap);
		     cmd.setString(2,matkhau);//Gán tham số cho câu lệnh sql 
		     ResultSet rs=cmd.executeQuery(); 
		        return rs.next(); 
		      }catch(Exception loi){ 
		     loi.printStackTrace();
		     System.out.print("Loi: "+loi) ; 
		     return false; 
		} 
		} 
}
