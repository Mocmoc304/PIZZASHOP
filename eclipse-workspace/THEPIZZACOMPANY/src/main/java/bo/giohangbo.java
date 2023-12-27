package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	   
	   
	   public ArrayList<giohangbean> getAll() {
		   return ds;
	   }
	   
	   public void Them(String masanpham, String tensanpham,  long gia,String anh, long soluongmua) {
		   //Them vao ds 1 phan tu
		   int n=ds.size();
			for(int i=0;i<n;i++){
			if(ds.get(i).getTensanpham().toLowerCase().trim().equals(tensanpham.
			toLowerCase().trim())){
			long sl=ds.get(i).getSoluongmua()+1;
			 ds.get(i).setSoluongmua(sl);
			 long g= ds.get(i).getGia();
			 long tt= sl*g;
			 ds.get(i).setThanhtien(tt);
			 return;
			 }
			}
			giohangbean h= new giohangbean(masanpham, tensanpham, gia , anh, soluongmua);
			ds.add(h);
		   
	   }
	   
	   public void Xoa(String masanpham) {
		   //xoa 1 phan tu ra khỏi danh sách
		   for(giohangbean g: ds) {
			   if(g.getMasanpham().equals(masanpham)) {
				   ds.remove(g);
				   return;
			   }
		   }
	   }
	   
	   public void CapNhatsoluong(String masanpham,long soluongmua) {
		   //Sửa lại số lượng mua trong mảng danh sách
		   int n=ds.size();
			for(int i=0;i<n;i++){
			if(ds.get(i).getMasanpham().toLowerCase().trim().equals(masanpham.
			toLowerCase().trim())){
				long sl = soluongmua;
				 ds.get(i).setSoluongmua(sl);
				 long g= ds.get(i).getGia();
				 long tt= sl*g;
				 ds.get(i).setThanhtien(tt);
			}
			}
			return;
		   
	   }
	   
	   public long TongTien() {
		   long s=0;
		   int n=ds.size();
			for(int i=0;i<n;i++){
			s=s+ds.get(i).getThanhtien();
			}
		   return s;
	   }

}
