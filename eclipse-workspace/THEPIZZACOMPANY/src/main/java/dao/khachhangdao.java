package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;

public class khachhangdao {
	public int AddKhachhang(String hoten,String email, String tendn, String pass) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "insert into khachhang(hoten, email, tendn, password) values(?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, hoten);
		cmd.setString(2, email);
		cmd.setString(3, tendn);
		cmd.setString(4, pass);
	    int rs = cmd.executeUpdate();
	    return rs;
	}
	public khachhangbean getThongTinkh(String mkh) throws Exception {
		khachhangbean kh = new khachhangbean();
		// b1 ket noi vao csdl: QlSach
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2 tao cau lenh sql
		String sql = "select * from khachhang where makh=?";
		// b3 tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, mkh);
		// b4 truyen tham so vao cau lenh neu co
		// b5 thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		if(rs.next()) {
			long makh = rs.getLong("makh");// trong dau "" la ten truong trong csdl
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sodienthoai = rs.getString("sodienthoai");
			String email = rs.getString("email");
			String username = rs.getString("tendn");
			String pass = rs.getString("password");
			kh.setMakh(makh);
			kh.setHoten(hoten);
			kh.setDiachi(diachi);
			kh.setSodienthoai(sodienthoai);
			kh.setEmail(email);
			kh.setTendn(username);
			kh.setPassword(pass);
		}
		rs.close();
		kn.cn.close();
		return kh;
	}
	public khachhangbean getThongTin(String tendn, String password) throws Exception {
		khachhangbean kh = new khachhangbean();
		// b1 ket noi vao csdl: QlSach
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2 tao cau lenh sql
		String sql = "select * from khachhang where tendn=? and password=?";
		// b3 tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, password);
		// b4 truyen tham so vao cau lenh neu co
		// b5 thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		if(rs.next()) {
			long makh = rs.getLong("makh");// trong dau "" la ten truong trong csdl
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sodienthoai = rs.getString("sodienthoai");
			String email = rs.getString("email");
			String username = rs.getString("tendn");
			String pass = rs.getString("password");
			kh.setMakh(makh);
			kh.setHoten(hoten);
			kh.setDiachi(diachi);
			kh.setSodienthoai(sodienthoai);
			kh.setEmail(email);
			kh.setTendn(username);
			kh.setPassword(pass);
		}
		rs.close();
		kn.cn.close();
		return kh;
	}

	public ArrayList<khachhangbean> getKhachang(String tendn, String pass) throws Exception {
		ArrayList<khachhangbean> ds = new ArrayList<khachhangbean>();
		// b1 ket noi vao csdl: QlSach
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2 tao cau lenh sql
		String sql = "select * from khachhang where tendn=? and password=?";
		// b3 tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, pass);
		// b4 truyen tham so vao cau lenh neu co
		// b5 thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long makh = rs.getLong("makh");// trong dau "" la ten truong trong csdl
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sodienthoai = rs.getString("sodienthoai");
			String email = rs.getString("email");
			String username = rs.getString("tendn");
			String password = rs.getString("password");
			ds.add(new khachhangbean(makh, hoten, diachi, sodienthoai, email, username, password));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public boolean  kt(String tendn, String password)throws Exception  { 
		   try{ 
			   KetNoi kn = new KetNoi();
				kn.ketnoi();  
		     String sql="select * from khachhang where TenDN=? and password=?"; 
		     PreparedStatement cmd= kn.cn.prepareStatement(sql) ; 
		     cmd.setString(1, tendn);
		     cmd.setString(2,password);//Gán tham số cho câu lệnh sql 
		     ResultSet rs=cmd.executeQuery(); 
		        return rs.next(); 
		      }catch(Exception loi){ 
		     loi.printStackTrace();
		     System.out.print("Loi: "+loi) ; 
		     return false; 
		} 
		} 

	public boolean  ktDangKy(String tendn)throws Exception  { 
		   try{ 
			   KetNoi kn = new KetNoi();
				kn.ketnoi();  
		     String sql="select * from khachhang where tendn=? "; 
		     PreparedStatement cmd= kn.cn.prepareStatement(sql) ; 
		     cmd.setString(1, tendn); //Gán tham số cho câu lệnh sql 
		     ResultSet rs=cmd.executeQuery(); 
		        return rs.next(); 
		      }catch(Exception loi){ 
		     loi.printStackTrace();
		     System.out.print("Loi: "+loi) ; 
		     return false; 
		} 
		} 

}
