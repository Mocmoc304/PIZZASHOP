package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.sanphambean;

public class sanphamdao {
	public ArrayList<sanphambean> getSanPham() throws Exception{
		ArrayList<sanphambean> ds = new ArrayList<sanphambean>();
		//b1 ket noi vao csdl: The Pizza Company
				KetNoi kn = new KetNoi();
				kn.ketnoi();
				//b2 tao cau lenh sql
				String sql="select * from SanPham";
				//b3 tao cau lenh
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				//b4 truyen tham so vao cau lenh neu co
				//b5 thuc hien cau lenh
				ResultSet rs = cmd.executeQuery();
				while(rs.next()) {
					String masanpham = rs.getString("MaSanPham");//trong dau "" la ten truong trong csdl
					String tensanpham = rs.getString("TenSanPham");
					long gia = rs.getLong("Gia");
					String anh = rs.getString("Anh");
					String noidung = rs.getString("NoiDung");
					String madanhmuc = rs.getString("MaDanhMuc");
					ds.add(new sanphambean(masanpham, tensanpham, gia, anh, noidung, madanhmuc));
					
				}
				rs.close();
				kn.cn.close();
				return ds;
	}
	public int getSLSanPham() throws Exception{
		//b1 ket noi vao csdl: The Pizza Company
				KetNoi kn = new KetNoi();
				kn.ketnoi();
				//b2 tao cau lenh sql
				String sql="select count(*) from SanPham";
				//b3 tao cau lenh
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				//b4 truyen tham so vao cau lenh neu co
				//b5 thuc hien cau lenh
				ResultSet rs = cmd.executeQuery();
				while(rs.next()) {
                    return rs.getInt(1);
				}
				rs.close();
				kn.cn.close();
				return 0;
	}
	public int getSLSanPhamcuaDM(String madm) throws Exception{
		//b1 ket noi vao csdl: The Pizza Company
				KetNoi kn = new KetNoi();
				kn.ketnoi();
				//b2 tao cau lenh sql
				String sql="select count(*) from SanPham where MaDanhMuc=?";
				//b3 tao cau lenh
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				//b4 truyen tham so vao cau lenh neu co
				cmd.setString(1, madm);
				//b5 thuc hien cau lenh
				ResultSet rs = cmd.executeQuery();
				while(rs.next()) {
                    return rs.getInt(1);
				}
				rs.close();
				kn.cn.close();
				return 0;
	}
	public int getSLSanPhamcuaSearch(String key) throws Exception{
		//b1 ket noi vao csdl: The Pizza Company
				KetNoi kn = new KetNoi();
				kn.ketnoi();
				//b2 tao cau lenh sql
				String sql="select count(*) from SanPham where TenSanPham like ? or NoiDung like ?";
				//b3 tao cau lenh
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				//b4 truyen tham so vao cau lenh neu co
				cmd.setString(1, "%" + key + "%");
				cmd.setString(2, "%" + key + "%");
				//b5 thuc hien cau lenh
				ResultSet rs = cmd.executeQuery();
				while(rs.next()) {
                    return rs.getInt(1);
				}
				rs.close();
				kn.cn.close();
				return 0;
	}
	public ArrayList<sanphambean> Pagination(int index) throws Exception{
		ArrayList<sanphambean> ds = new ArrayList<sanphambean>();
		//b1 ket noi vao csdl: The Pizza Company
				KetNoi kn = new KetNoi();
				kn.ketnoi();
				//b2 tao cau lenh sql
				String sql="select * from SanPham \r\n"
						+ "order by MaSanPham \r\n"
						+ "offset ? rows fetch next 9 rows only ";
				//b3 tao cau lenh
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				//b4 truyen tham so vao cau lenh neu co
				cmd.setInt(1, (index-1)*9);
				//b5 thuc hien cau lenh
				ResultSet rs = cmd.executeQuery();
				while(rs.next()) {
					String masanpham = rs.getString("MaSanPham");//trong dau "" la ten truong trong csdl
					String tensanpham = rs.getString("TenSanPham");
					long gia = rs.getLong("Gia");
					String anh = rs.getString("Anh");
					String noidung = rs.getString("NoiDung");
					String madanhmuc = rs.getString("MaDanhMuc");
					ds.add(new sanphambean(masanpham, tensanpham, gia, anh, noidung, madanhmuc));
					
				}
				rs.close();
				kn.cn.close();
				return ds;
	}
	public ArrayList<sanphambean> TimDanhMuc(String madm, int index) throws Exception{
		ArrayList<sanphambean> ds = new ArrayList<sanphambean>();
		//b1 ket noi vao csdl: The Pizza Company
				KetNoi kn = new KetNoi();
				kn.ketnoi();
				//b2 tao cau lenh sql
				String sql="select * from sanpham where MaDanhMuc= ?\r\n"
						+ "order by MaSanPham\r\n"
						+ "offset ? rows fetch next 9 rows only ";
				//b3 tao cau lenh
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				//b4 truyen tham so vao cau lenh neu co
				cmd.setString(1, madm);
				cmd.setInt(2, (index-1)*9);
				//b5 thuc hien cau lenh
				ResultSet rs = cmd.executeQuery();
				while(rs.next()) {
					String masanpham = rs.getString("MaSanPham");//trong dau "" la ten truong trong csdl
					String tensanpham = rs.getString("TenSanPham");
					long gia = rs.getLong("Gia");
					String anh = rs.getString("Anh");
					String noidung = rs.getString("NoiDung");
					String madanhmuc = rs.getString("MaDanhMuc");
					ds.add(new sanphambean(masanpham, tensanpham, gia, anh, noidung, madanhmuc));
					
				}
				rs.close();
				kn.cn.close();
				return ds;
	
	}
	
public ArrayList<sanphambean> Tim(String key, int index) throws Exception{
	ArrayList<sanphambean> ds = new ArrayList<sanphambean>();
	//b1 ket noi vao csdl: The Pizza Company
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//b2 tao cau lenh sql
			String sql="select * from SanPham where TenSanPham like ? or NoiDung like ?\r\n"
					+ "order by MaSanPham\r\n"
					+ "offset ? rows fetch next 9 rows only ";
			//b3 tao cau lenh
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			//b4 truyen tham so vao cau lenh neu co
			cmd.setString(1, "%" + key + "%");
			cmd.setString(2, "%" + key + "%");
			cmd.setInt(3, (index-1)*9);
			//b5 thuc hien cau lenh
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String masanpham = rs.getString("MaSanPham");//trong dau "" la ten truong trong csdl
				String tensanpham = rs.getString("TenSanPham");
				long gia = rs.getLong("Gia");
				String anh = rs.getString("Anh");
				String noidung = rs.getString("NoiDung");
				String madanhmuc = rs.getString("MaDanhMuc");
				ds.add(new sanphambean(masanpham, tensanpham, gia, anh, noidung, madanhmuc));
				
			}
			rs.close();
			kn.cn.close();
			return ds;
	}
	
	public ArrayList<sanphambean> getChiTiet(String masp) throws Exception{
		ArrayList<sanphambean> ds = new ArrayList<sanphambean>();
		//b1 ket noi vao csdl: The Pizza Company
				KetNoi kn = new KetNoi();
				kn.ketnoi();
				//b2 tao cau lenh sql
				String sql="select * from SanPham where MaSanPham=?";
				//b3 tao cau lenh
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				//b4 truyen tham so vao cau lenh neu co
				cmd.setString(1, masp);
				//b5 thuc hien cau lenh
				ResultSet rs = cmd.executeQuery();
				
				while(rs.next()) {
					String masanpham = rs.getString("MaSanPham");//trong dau "" la ten truong trong csdl
					String tensanpham = rs.getString("TenSanPham");
					long gia = rs.getLong("Gia");
					String anh = rs.getString("Anh");
					String noidung = rs.getString("NoiDung");
					String madanhmuc = rs.getString("MaDanhMuc");
					ds.add(new sanphambean(masanpham, tensanpham, gia, anh, noidung, madanhmuc));
					
				}
				rs.close();
				kn.cn.close();
				return ds;
	}
	
	
	public ArrayList<sanphambean> getSanPhamPopular() throws Exception{
		ArrayList<sanphambean> ds = new ArrayList<sanphambean>();
		//b1 ket noi vao csdl: The Pizza Company
				KetNoi kn = new KetNoi();
				kn.ketnoi();
				//b2 tao cau lenh sql
				String sql="select top 9 * from SanPham where home = 1";
				//b3 tao cau lenh
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				//b4 truyen tham so vao cau lenh neu co
				//b5 thuc hien cau lenh
				ResultSet rs = cmd.executeQuery();
				while(rs.next()) {
					String masanpham = rs.getString("MaSanPham");//trong dau "" la ten truong trong csdl
					String tensanpham = rs.getString("TenSanPham");
					long gia = rs.getLong("Gia");
					String anh = rs.getString("Anh");
					String noidung = rs.getString("NoiDung");
					String madanhmuc = rs.getString("MaDanhMuc");
					ds.add(new sanphambean(masanpham, tensanpham, gia, anh, noidung, madanhmuc));
					
				}
				rs.close();
				kn.cn.close();
				return ds;
	}
	public ArrayList<sanphambean> getSanPhamToday() throws Exception{
		ArrayList<sanphambean> ds = new ArrayList<sanphambean>();
		//b1 ket noi vao csdl: The Pizza Company
				KetNoi kn = new KetNoi();
				kn.ketnoi();
				//b2 tao cau lenh sql
				String sql="select top 9 * from sanpham order by RAND()";
				//b3 tao cau lenh
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				//b4 truyen tham so vao cau lenh neu co
				//b5 thuc hien cau lenh
				ResultSet rs = cmd.executeQuery();
				while(rs.next()) {
					String masanpham = rs.getString("MaSanPham");//trong dau "" la ten truong trong csdl
					String tensanpham = rs.getString("TenSanPham");
					long gia = rs.getLong("Gia");
					String anh = rs.getString("Anh");
					String noidung = rs.getString("NoiDung");
					String madanhmuc = rs.getString("MaDanhMuc");
					ds.add(new sanphambean(masanpham, tensanpham, gia, anh, noidung, madanhmuc));
					
				}
				rs.close();
				kn.cn.close();
				return ds;
	}
	//Thêm sản phẩm
	public int Them(String masanpham, String tensanpham,long gia,String anh, String noidung,  String madanhmuc) throws Exception {
		String sql = "insert into Sanpham(MaSanPham, TenSanPham, Gia, Anh, NoiDung, MaDanhMuc ) values(?,?,?,?,?,?)";//them vo
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		PreparedStatement pre = kn.cn.prepareStatement(sql);
		
		pre.setString(1,masanpham);
		pre.setString(2,tensanpham);
	    pre.setLong(3, gia);
		pre.setString(4, anh);
		pre.setString(5, noidung);
		pre.setString(6, madanhmuc);
		return pre.executeUpdate();
	}
	//Sửa sản phẩm
	public int Sua( String tensanpham,long gia,String anh, String noidung,  String madanhmuc,String masanpham) throws Exception {
		String sql = "update sanpham set tensanpham=?,gia=?,anh=?,noidung=?,madanhmuc=? where masanpham=?";
		KetNoi kn = new KetNoi();
		kn.ketnoi();
	    PreparedStatement pre = kn.cn.prepareStatement(sql);
	   
		pre.setString(1,tensanpham);
	    pre.setLong(2, gia);
		pre.setString(3, anh);
		pre.setString(4,noidung);
		pre.setString(5, madanhmuc);
		pre.setString(6,masanpham);
		return pre.executeUpdate();
	}
	public int Xoa(String masanpham) throws Exception {
		String sql =  "delete from	sanpham  where masanpham = ?";
		KetNoi kn = new KetNoi();
		kn.ketnoi();
	    PreparedStatement pre = kn.cn.prepareStatement(sql);
		
		pre.setString(1,masanpham);
		
		return pre.executeUpdate();
		
	}
	public int Update(String madanhmuc) throws Exception{
		String sql = "update sanpham set MaDanhMuc = null where MaDanhMuc = ?";
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		PreparedStatement pre = kn.cn.prepareStatement(sql);
		pre.setString(1, madanhmuc);
		return pre.executeUpdate();
	}

}
