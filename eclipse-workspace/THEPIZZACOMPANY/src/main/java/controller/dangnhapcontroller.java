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
import nl.captcha.Captcha;

/**
 * Servlet implementation class dangnhapcontroller
 */
@WebServlet("/dangnhapcontroller")
public class dangnhapcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }
    private int loginAttempts = 0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			HttpSession session=request.getSession();
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			String answer = request.getParameter("answer");
			String tamun = request.getParameter("txtun");
			String tampass= request.getParameter("txtpass");
			danhmucbo dmbo = new danhmucbo();
			request.setAttribute("dsdanhmuc", dmbo.getDanhMuc());
			khachhangbo khbo = new khachhangbo();
			khachhangbean kh = new khachhangbean();
			if(tamun !=null && tampass != null){
				if(khbo.kt(tamun, bo.md5.ecrypt(tampass))==true){
					   kh = khbo.getThongTin(tamun, bo.md5.ecrypt(tampass));
					   session.setAttribute("dn", khbo.getAll()); 
					   session.setAttribute("kh", kh); 
						response.sendRedirect("homecontroller");
						loginAttempts = 0;
						return;
						
					  }
				else {
					request.setAttribute("mess", "Đăng nhập sai!");
					loginAttempts++;
				}}
					
			if (loginAttempts >= 3) {
				if(answer==null) {
					response.sendRedirect("Captcha.jsp");
				    return;
				}
				else
				if (captcha.isCorrect(answer)) {
				   response.getWriter().print("CaptCha dung");
				   session.setAttribute("dn", khbo); 
				   session.setAttribute("kh", kh); 
				   response.sendRedirect("homecontroller");
				   return;
				} else {
					 response.getWriter().print("CaptCha sai");
				}

			}
			
			RequestDispatcher rd= request.getRequestDispatcher("dangnhap.jsp");
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
