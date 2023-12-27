package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.chitiethoadonbo;
import bo.danhmucbo;
import bo.sanphambo;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
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
			
			String msp= request.getParameter("msp");
			String mdm = request.getParameter("mdm");
			sanphambo spbo = new sanphambo();
			danhmucbo dmbo = new danhmucbo();
			chitiethoadonbo ctbo = new chitiethoadonbo();
			if(msp!=null) {
		    ctbo.CapNhatDH(msp);
			spbo.Xoa(msp);
			response.sendRedirect("quanlysanphamcontroller");}
			else if(mdm!=null) {
				spbo.Update(mdm);
				dmbo.Xoa(mdm);
				response.sendRedirect("quanlydanhmuccontroller");
			}
			
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
