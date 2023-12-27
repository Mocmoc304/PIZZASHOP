package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class hoadondao {
	public int Them(long makh) throws Exception{
		  KetNoi kn= new KetNoi();
		  kn.ketnoi();
		  String sql="insert into hoadon(makh,NgayMua,damua) values(?,?,0)";
		  PreparedStatement cmd= kn.cn.prepareStatement(sql);
		  cmd.setLong(1, makh);
	      java.util.Date n1= new java.util.Date();//Lay ngay gio hien tai
		  SimpleDateFormat dd= new SimpleDateFormat("yyyy-MM-dd");
		  String st=dd.format(n1);
		  java.util.Date n2= dd.parse(st);
		  cmd.setDate(2, new java.sql.Date(n2.getTime()));
		  int kq=cmd.executeUpdate();
		  cmd.close(); kn.cn.close();
		  return kq;}

	public long getMaxHd() throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "select max(MaHoaDon) as MaxHd from hoadon";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long max = 0;
		if (rs.next())
			max = rs.getLong("MaxHd");
		rs.close();
		kn.cn.close();
		return max;
	}
	public int getSLHD() throws Exception{
		String sql = "select count(*) from HoaDon";
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			return rs.getInt(1);
		}
		rs.close();
		kn.cn.close();
		return 0;
	}

}
