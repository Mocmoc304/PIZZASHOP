package bo;

import java.util.ArrayList;

import bean.adminxacnhanbean;
import dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao ctdao= new chitiethoadondao();
	public int Them(String MaSanPham,long SoLuongMua,
			 long MaHoaDon) throws Exception{
		return ctdao.Them(MaSanPham, SoLuongMua, MaHoaDon);
	}
	public ArrayList<adminxacnhanbean> getXacNhan() throws Exception{
		System.out.println("Vao duoc ham");
		return ctdao.getXacNhan();
	}
	public int CapNhat(long MaCT) throws Exception{
		return ctdao.CapNhat(MaCT);
	}
	public int CapNhatDH(String masp)throws Exception{
	    return ctdao.CapNhatDH(masp);
	}
	public String getMaKH(String MaCT)throws Exception{
		return ctdao.getMaKH(MaCT);
	}
	 public long ThongKe() throws Exception{
		 return ctdao.ThongKe();
	 }

}
