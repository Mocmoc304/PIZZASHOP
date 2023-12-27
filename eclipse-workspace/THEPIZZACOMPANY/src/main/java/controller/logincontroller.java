package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bean.loginbean;

import bo.loginbo;

/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
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
			String tamun = request.getParameter("txtun");
			String tampass= request.getParameter("txtpass");
			HttpSession session = request.getSession();
			loginbo logbo = new loginbo();
			loginbean logbean = new loginbean();
			if(tamun !=null && tampass != null){
				if(logbo.kt(tamun, bo.md5.ecrypt(tampass))==true){
					   
					   session.setAttribute("dnhap", logbo.getAll()); 
					   session.setAttribute("admin", logbean); 
						response.sendRedirect("quantricontroller");
						return;
						
					  }
				
					else {
						request.setAttribute("mess", "Đăng nhập sai!");
					}
				
			}
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
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
