package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachhangbean;
import bo.chitiethoadonbo;
import bo.giohangbo;
import bo.hoadonbo;

/**
 * Servlet implementation class xacnhancontroller
 */
@WebServlet("/xacnhancontroller")
public class xacnhancontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhancontroller() {
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
				HttpSession session = request.getSession();
				khachhangbean kh= (khachhangbean)session.getAttribute("kh");
				if(kh==null) {
					response.sendRedirect("dangnhapcontroller");
				    return;}
				else {
					hoadonbo hdbo= new hoadonbo();
					chitiethoadonbo ctbo= new chitiethoadonbo();
					//tao ra 1 hoa don
					hdbo.Them(kh.getMakh());
					System.out.println("makh "+kh.getMakh());
					long maxhd= hdbo.getMaxHd();
					//Them vao bang chitietHD
					giohangbo gh=
							(giohangbo)session.getAttribute("gh");
					for(giohangbean h: gh.ds)
						ctbo.Them(h.getMasanpham(), h.getSoluongmua(), maxhd);
					session.removeAttribute("gh");
					}
					
					response.sendRedirect("dathangcontroller");
					return;
				
			} catch (Exception e) {
				e.printStackTrace();
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
