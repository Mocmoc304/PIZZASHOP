package bo;

import java.util.ArrayList;

import bean.lichsubean;
import dao.lichsudao;

public class lichsubo {
	lichsudao lsdao = new lichsudao();
	 public ArrayList<lichsubean> ThongTinDHChuaXacNhan(String makh) throws Exception{
		 return lsdao.ThongTinDHChuaXacNhan(makh);
	 }
	 public ArrayList<lichsubean> ThongTinDHDaXacNhan(String makh) throws Exception{
		 return lsdao.ThongTinDHDaXacNhan(makh);
	 }

}
