package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.chitiethoadonbo;
import bo.email;
import bo.hoadonbo;
import bo.khachhangbo;

/**
 * Servlet implementation class quantricontroller
 */
@WebServlet("/quantricontroller")
public class quantricontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quantricontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		try {
			chitiethoadonbo ctbo = new chitiethoadonbo();
			String MaCT = request.getParameter("mct");
			khachhangbean kh = new khachhangbean();
			khachhangbo khbo = new khachhangbo();
			hoadonbo hdbo = new hoadonbo();
			request.setAttribute("tk", ctbo.ThongKe());
			request.setAttribute("dh", hdbo.getSLHD());
			// Trường hợp chạy lần đầu mã == null
			if (MaCT == null) {
				request.setAttribute("ds", ctbo.getXacNhan());
			}

			// Trường họp muốn cập nhật mã đơn hàng đó, admin bấm xác nhận
			// Admin gởi lên một mã đơn hàng lên server => Mã đơn hơn # null thì update
			if (MaCT != null) {
				// Gọi hàm update truyênf vào mã
				ctbo.CapNhat(Long.parseLong(MaCT));
				String makh = ctbo.getMaKH(MaCT);
				if(makh!=null) {
				System.out.println("makh "+ctbo.getMaKH(MaCT));
				kh = khbo.getThongTinkh(makh);
				System.out.println("email" +kh.getEmail());
				String tieude = "Your order has been confirmed.";
		    	String noidung = "<!DOCTYPE html>\n"
		    			+ "<html lang=\"en\">\n"
		    			+ "\n"
		    			+ "<head>\n"
		    			+ "</head>\n"
		    			+ "\n"
		    			+ "<body>\n"
		    			+ " <h3 style=\"color: red;\">Your order has been confirmed.</h3>\n"
		    			+ "<div>Cám ơn bạn đã quan tâm đến cửa hàng của chúng tôi.</div>\n"
		    			+ "<div>Đơn hàng của bạn đax được xác nhận và đang trên đường vận chuyển đến nơi.</div>\n"
		    			+ "<h3 style=\"color: green;\">Thank you very much!</h3>\n"
		    			+ "\n"
		    			+ "</body>\n"
		    			+ "\n"
		    			+ "</html>\n";
		    	bo.email.sendEmail(kh.getEmail(), tieude, noidung);
				response.sendRedirect("quantricontroller");
				return;
				}
			}

			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
