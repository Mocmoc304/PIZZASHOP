package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.adminxacnhanbean;

public class chitiethoadondao {
	public int Them(String MaSanPham,long SoLuongMua,
			long MaHoaDon) throws Exception{
		  KetNoi kn= new KetNoi();
		  kn.ketnoi();
		  String sql=
	"insert into ChiTietHoaDon(MaSanPham,SoLuongMua,MaHoaDon, damua) values(?,?,?,0)";
		  PreparedStatement cmd= kn.cn.prepareStatement(sql);
		  cmd.setString(1, MaSanPham);
		  cmd.setLong(2, SoLuongMua);
		  cmd.setLong(3, MaHoaDon);
		  int kq=cmd.executeUpdate();
		  cmd.close(); kn.cn.close();
		  return kq;
	  }
	public ArrayList<adminxacnhanbean> getXacNhan() throws Exception{
		ArrayList<adminxacnhanbean> ds = new ArrayList<adminxacnhanbean>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		//b2 tao cau lenh sql
		String sql="select * from Vadminxacnhan";
		//b3 tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//b4 truyen tham so vao cau lenh neu co
		//b5 thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			long machitiethd = rs.getLong("MaChiTietHD");
			String hoten= rs.getString("hoten");
			String tensanpham=rs.getString("tensanpham");
			long gia= rs.getLong("gia");
			long soluongmua=rs.getLong("SoLuongMua");
			long thanhtien=rs.getLong("thanhtien");
			boolean danmua=rs.getBoolean("damua");
			ds.add(new adminxacnhanbean(machitiethd, hoten, tensanpham, gia, soluongmua, thanhtien, danmua));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int CapNhat(long MaCT) throws Exception{
		  KetNoi kn= new KetNoi();
		  kn.ketnoi();
		  String sql=
	"Update ChiTietHoaDon set damua=1 where MaChiTietHD=?";
		  PreparedStatement cmd= kn.cn.prepareStatement(sql);
		  cmd.setLong(1, MaCT);
		  int kq=cmd.executeUpdate();
		  cmd.close(); kn.cn.close();
		  return kq;
	  }
	public int CapNhatDH(String masp)throws Exception{
		String sql = "update ChiTietHoaDon set MaSanPham = null where MaSanPham = ?";
		 KetNoi kn= new KetNoi();
		  kn.ketnoi();
		  PreparedStatement cmd= kn.cn.prepareStatement(sql);
		  cmd.setString(1, masp);
		  int kq=cmd.executeUpdate();
		  cmd.close(); kn.cn.close();
		  return kq;
	}
    public String getMaKH(String MaCT)throws Exception{
    	String sql = "SELECT        dbo.HoaDon.MaKH\r\n"
    			+ "FROM            dbo.ChiTietHoaDon INNER JOIN\r\n"
    			+ "                         dbo.HoaDon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.HoaDon.MaHoaDon\r\n"
    			+ "WHERE        (dbo.ChiTietHoaDon.MaChiTietHD = ?)";
    	KetNoi kn= new KetNoi();
		kn.ketnoi();
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, MaCT);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			 String makh = rs.getString("MaKH");
			return makh;
		}
		rs.close();
		kn.cn.close();
		return null;
    }
    public long ThongKe() throws Exception{
    	String sql = "SELECT        SUM(dbo.SanPham.Gia * dbo.ChiTietHoaDon.SoLuongMua) AS tongtien\r\n"
    			+ "FROM            dbo.ChiTietHoaDon INNER JOIN\r\n"
    			+ "                         dbo.HoaDon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.HoaDon.MaHoaDon INNER JOIN\r\n"
    			+ "                         dbo.KhachHang ON dbo.HoaDon.MaKH = dbo.KhachHang.MaKH INNER JOIN\r\n"
    			+ "                         dbo.SanPham ON dbo.ChiTietHoaDon.MaSanPham = dbo.SanPham.MaSanPham"
    			+ "                         WHERE        (dbo.ChiTietHoaDon.DaMua = 1)";
    	KetNoi kn= new KetNoi();
		kn.ketnoi();
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			return rs.getLong(1);
		}
		rs.close();
		kn.cn.close();
		return 0;
    }
}
