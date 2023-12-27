package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.danhmucbo;

/**
 * Servlet implementation class quanlydanhmuccontroller
 */
@WebServlet("/quanlydanhmuccontroller")
public class quanlydanhmuccontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanlydanhmuccontroller() {
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
			String madanhmuc= request.getParameter("madm");
			String tendanhmuc = request.getParameter("tendm");
			danhmucbo dmbo = new danhmucbo();
			request.setAttribute("dsdanhmuc", dmbo.getDanhMuc());
			if (request.getContentLength() <= 0) {// Chay lan dau
				RequestDispatcher rd = request.getRequestDispatcher("quanlydm.jsp");
				rd.forward(request, response);
				return;
			}
			
			else if(madanhmuc !=null && tendanhmuc!=null) {
				if(dmbo.ktDanhMuc(madanhmuc)) {
					request.setAttribute("mess", "Danh mục đã tồn tại!");
				}
				else {
					dmbo.Them(madanhmuc, tendanhmuc);
					response.sendRedirect("quanlydanhmuccontroller");
				}
			}
			RequestDispatcher rd= request.getRequestDispatcher("quanlydm.jsp");
			rd.forward(request, response);
			
			
		}
		catch (Exception e) {
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
