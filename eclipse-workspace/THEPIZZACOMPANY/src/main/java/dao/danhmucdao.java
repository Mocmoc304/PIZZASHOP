package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.danhmucbean;

public class danhmucdao {
	public ArrayList<danhmucbean> getDanhMuc() throws Exception{
		ArrayList<danhmucbean> ds = new ArrayList<danhmucbean>();
		//b1 ket noi vao csdl: The Pizza Company
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		//b2 tao cau lenh sql
		String sql="select * from DanhMuc";
		//b3 tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//b4 truyen tham so vao cau lenh neu co
		//b5 thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String madanhmuc= rs.getString("MaDanhMuc");//trong dau "" la ten truong trong csdl
			String tendanhmuc= rs.getString("TenDanhMuc");
			ds.add(new danhmucbean(madanhmuc, tendanhmuc));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public boolean  ktDanhMuc(String madanhmuc)throws Exception  { 
		   try{ 
			   KetNoi kn = new KetNoi();
				kn.ketnoi();  
		     String sql="select * from DanhMuc where MaDanhMuc=? "; 
		     PreparedStatement cmd= kn.cn.prepareStatement(sql) ; 
		     cmd.setString(1, madanhmuc); //Gán tham số cho câu lệnh sql 
		     ResultSet rs=cmd.executeQuery(); 
		        return rs.next(); 
		      }catch(Exception loi){ 
		     loi.printStackTrace();
		     System.out.print("Loi: "+loi) ; 
		     return false; 
		} 
		}
	public ArrayList<danhmucbean> getChiTiet(String madm) throws Exception{
		ArrayList<danhmucbean> ds = new ArrayList<danhmucbean>();
		//b1 ket noi vao csdl: The Pizza Company
				KetNoi kn = new KetNoi();
				kn.ketnoi();
				//b2 tao cau lenh sql
				String sql="select * from DanhMuc where MaDanhMuc=? ";
				//b3 tao cau lenh
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				//b4 truyen tham so vao cau lenh neu co
				cmd.setString(1, madm);
				//b5 thuc hien cau lenh
				ResultSet rs = cmd.executeQuery();
				
				while(rs.next()) {
					String madanhmuc = rs.getString("MaDanhMuc");//trong dau "" la ten truong trong csdl
					String tendanhmuc = rs.getString("TenDanhMuc");
					ds.add(new danhmucbean(madanhmuc, tendanhmuc));
					
				}
				rs.close();
				kn.cn.close();
				return ds;
	}
	public int Them(String madanhmuc, String tendanhmuc) throws Exception {
		String sql = "insert into DanhMuc(MaDanhMuc, TenDanhMuc) values(?,?)";//them vo
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		PreparedStatement pre = kn.cn.prepareStatement(sql);
		
		pre.setString(1,madanhmuc);
		pre.setString(2,tendanhmuc);
		return pre.executeUpdate();
	}
	//Sửa sản phẩm
	public int Sua(String tendanhmuc, String madanhmuc) throws Exception {
		String sql = "update DanhMuc set tendanhmuc =? where madanhmuc=?";
		KetNoi kn = new KetNoi();
		kn.ketnoi();
	    PreparedStatement pre = kn.cn.prepareStatement(sql);
	   
		pre.setString(1,tendanhmuc);
		pre.setString(2,madanhmuc);
		return pre.executeUpdate();
	}
	public int Xoa(String madanhmuc) throws Exception {
		String sql =  "delete from	DanhMuc  where madanhmuc = ?";
		KetNoi kn = new KetNoi();
		kn.ketnoi();
	    PreparedStatement pre = kn.cn.prepareStatement(sql);
		
		pre.setString(1,madanhmuc);
		
		return pre.executeUpdate();
		
	}

}
