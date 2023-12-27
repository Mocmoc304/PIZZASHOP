package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.lichsubean;

public class lichsudao {
  public ArrayList<lichsubean> ThongTinDHChuaXacNhan(String makh) throws Exception{
	  ArrayList<lichsubean> ds = new ArrayList<lichsubean>();
	//b1 ket noi vao csdl: The Pizza Company
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//b2 tao cau lenh sql
			String sql="SELECT        dbo.SanPham.TenSanPham, dbo.SanPham.Gia, dbo.ChiTietHoaDon.SoLuongMua, dbo.SanPham.Gia * dbo.ChiTietHoaDon.SoLuongMua AS thanhtien, dbo.ChiTietHoaDon.DaMua, dbo.SanPham.Anh, dbo.KhachHang.MaKH, \r\n"
					+ "                         dbo.HoaDon.NgayMua, dbo.SanPham.MaSanPham\r\n"
					+ "FROM            dbo.ChiTietHoaDon INNER JOIN\r\n"
					+ "                         dbo.HoaDon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.HoaDon.MaHoaDon INNER JOIN\r\n"
					+ "                         dbo.KhachHang ON dbo.HoaDon.MaKH = dbo.KhachHang.MaKH INNER JOIN\r\n"
					+ "                         dbo.SanPham ON dbo.ChiTietHoaDon.MaSanPham = dbo.SanPham.MaSanPham\r\n"
					+ "WHERE        (dbo.ChiTietHoaDon.DaMua = 0) AND (dbo.KhachHang.MaKH = ?) order by  dbo.HoaDon.NgayMua DESC";
			//b3 tao cau lenh
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			//b4 truyen tham so vao cau lenh neu co
			 cmd.setString(1, makh);
			//b5 thuc hien cau lenh
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String masanpham= rs.getString("MaSanPham");//trong dau "" la ten truong trong csdl
				String tensanpham= rs.getString("TenSanPham");
				long soluongmua = rs.getLong("SoLuongMua");
				long gia = rs.getLong("Gia");
				long makhachhang = rs.getLong("MaKH");
				long thanhtien = rs.getLong("thanhtien");
				Date ngaymua = rs.getDate("ngaymua");
				Boolean damua = rs.getBoolean("DaMua");
				String anh = rs.getString("anh");
				ds.add(new lichsubean(masanpham, tensanpham, soluongmua, gia, makhachhang, thanhtien, ngaymua, damua, anh));
			}
			rs.close();
			kn.cn.close();
			return ds;
  }
  public ArrayList<lichsubean> ThongTinDHDaXacNhan(String makh) throws Exception{
	  ArrayList<lichsubean> ds = new ArrayList<lichsubean>();
	//b1 ket noi vao csdl: The Pizza Company
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//b2 tao cau lenh sql
			String sql="SELECT        dbo.SanPham.TenSanPham, dbo.SanPham.Gia, dbo.ChiTietHoaDon.SoLuongMua, dbo.SanPham.Gia * dbo.ChiTietHoaDon.SoLuongMua AS thanhtien, dbo.ChiTietHoaDon.DaMua, dbo.SanPham.Anh, dbo.KhachHang.MaKH, \r\n"
					+ "                         dbo.HoaDon.NgayMua, dbo.SanPham.MaSanPham\r\n"
					+ "FROM            dbo.ChiTietHoaDon INNER JOIN\r\n"
					+ "                         dbo.HoaDon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.HoaDon.MaHoaDon INNER JOIN\r\n"
					+ "                         dbo.KhachHang ON dbo.HoaDon.MaKH = dbo.KhachHang.MaKH INNER JOIN\r\n"
					+ "                         dbo.SanPham ON dbo.ChiTietHoaDon.MaSanPham = dbo.SanPham.MaSanPham\r\n"
					+ "WHERE        (dbo.ChiTietHoaDon.DaMua = 1) AND (dbo.KhachHang.MaKH = ?) order by  dbo.HoaDon.NgayMua DESC";
			//b3 tao cau lenh
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			//b4 truyen tham so vao cau lenh neu co
			 cmd.setString(1, makh);
			//b5 thuc hien cau lenh
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String masanpham= rs.getString("MaSanPham");//trong dau "" la ten truong trong csdl
				String tensanpham= rs.getString("TenSanPham");
				long soluongmua = rs.getLong("SoLuongMua");
				long gia = rs.getLong("Gia");
				long makhachhang = rs.getLong("MaKH");
				long thanhtien = rs.getLong("thanhtien");
				Date ngaymua = rs.getDate("ngaymua");
				Boolean damua = rs.getBoolean("DaMua");
				String anh = rs.getString("anh");
				ds.add(new lichsubean(masanpham, tensanpham, soluongmua, gia, makhachhang, thanhtien, ngaymua, damua, anh));
			}
			rs.close();
			kn.cn.close();
			return ds;
  }
}
