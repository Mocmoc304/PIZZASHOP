package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.danhmucbo;
import bo.sanphambo;

/**
 * Servlet implementation class chitietcontroller
 */
@WebServlet("/chitietcontroller")
public class chitietcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chitietcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			danhmucbo dmbo = new danhmucbo();
			request.setAttribute("dsdanhmuc", dmbo.getDanhMuc());
		
			String msp = request.getParameter("msp");
            
			HttpSession session = request.getSession();
			
			
			
					sanphambo sp = new sanphambo();
					session.setAttribute("sp", sp.getChiTiet(msp));
							
			
			
			RequestDispatcher rd = request.getRequestDispatcher("chitiet.jsp");
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
