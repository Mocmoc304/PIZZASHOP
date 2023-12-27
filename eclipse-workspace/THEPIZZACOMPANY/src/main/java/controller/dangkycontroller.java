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
import bo.danhmucbo;
import bo.khachhangbo;

/**
 * Servlet implementation class dangkycontroller
 */
@WebServlet("/dangkycontroller")
public class dangkycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkycontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String tamn = request.getParameter("name");
		String tamun = request.getParameter("username");
		String tamemail = request.getParameter("email");
		String tampass = request.getParameter("password");
		String tamrepass = request.getParameter("repassword");
		HttpSession session = request.getSession();
		khachhangbo khbo = new khachhangbo();
		khachhangbean kh = new khachhangbean();
		
		try {
			danhmucbo dmbo = new danhmucbo();
			request.setAttribute("dsdanhmuc", dmbo.getDanhMuc());
		if(tamun !=null && tamemail !=null && tampass != null &&tampass !=null && tamrepass !=null ) {
			if(!tampass.equals(tamrepass)) 
		       { 
				request.setAttribute("kt", "Mật khẩu nhập lại không đúng!");
		    }
			
			else if(khbo.ktDangKy(tamun)==true) {
					request.setAttribute("kt", "Tên khách hàng đã tồn tại");
				   
				}
				else if(khbo.AddKhachhang(tamn, tamemail, tamun, bo.md5.ecrypt(tampass))==1) {

					kh = khbo.getThongTin(tamun, bo.md5.ecrypt(tampass));
					session.setAttribute("dn", khbo.getAll()); 
					   session.setAttribute("kh", kh); 
						response.sendRedirect("homecontroller");
						request.setAttribute("kt", "Success");
					return;
			   
			}
				
			
		}
		RequestDispatcher rd= request.getRequestDispatcher("dangky.jsp");
		rd.forward(request, response);
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
